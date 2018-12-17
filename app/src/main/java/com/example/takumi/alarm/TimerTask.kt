package com.example.takumi.alarm

import android.os.Vibrator
import android.util.Log
import android.widget.Spinner
import me.mattak.moment.Moment
import java.util.*
import kotlin.concurrent.schedule

class TimerTask {
    public var boolean = false
    fun load(spinner_H: Spinner, spinner_M: Spinner) {
        Timer().schedule(0, 1000) {
            val text_H = spinner_H.getSelectedItem() as String
            val text_M = spinner_M.getSelectedItem() as String

            var hour = Moment().hour + 9
            if (hour > 24) {
                hour = hour - 24
            }
            val minute = Moment().minute
            val second = Moment().second

            if (second == 0) {
                if (hour.toString() + "時" == text_H) {
                    if (minute.toString() + "分" == text_M) {
                        boolean = true
                    }
                }
            }
        }
    }
    fun run(sound:Music,vibrator:Vibrator){
        Timer().schedule(0, 1000, {
            if (boolean == true) {
                sound.start()
                vibrator.vibrate(300)
                boolean = false
            }
        })
    }
}
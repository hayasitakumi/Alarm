package com.example.takumi.alarm

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import android.widget.Spinner
import me.mattak.moment.Moment

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinner_H = findViewById<View>(R.id.spinner_Hour) as Spinner
        val spinner_M = findViewById<View>(R.id.spinner_Minute) as Spinner
        val spinner_S = findViewById<View>(R.id.spinner_Second) as Spinner

        val adapter_H = ArrayAdapter.createFromResource(
            this,
            R.array.str_Hour, android.R.layout.simple_spinner_item
        )
        val adapter_M = ArrayAdapter.createFromResource(
            this,
            R.array.str_Minute, android.R.layout.simple_spinner_item
        )
        val adapter_S = ArrayAdapter.createFromResource(
            this,
            R.array.str_Minute, android.R.layout.simple_spinner_item
        )

        adapter_H.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter_M.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter_S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_H.adapter = adapter_H
        Log.d("spinner", "debug")
        spinner_M.adapter = adapter_M
        spinner_S.adapter = adapter_S

//        val textView: TextView = findViewById(R.id.timer) as TextView
//
//        val calendar = Calendar.getInstance()
//        val hour = calendar.get(Calendar.HOUR)
//        val minute = calendar.get(Calendar.MINUTE)
//        val second = calendar.get(Calendar.SECOND)
//        textView.text = "${hour}時${minute}分${second}秒"
        val moment = Moment() // 引数に何も指定しなければ現在の日付が入る
        Log.d("debug", "${moment}")

        val sound_but: Button = findViewById(R.id.sound_button)
        val sound = Music()
        sound.load(assets.openFd("Japanese_School_Bell04-1.mp3"))
//
//
//        val mediaPlayer = MediaPlayer()
//        val afdescripter = assets.openFd("Japanese_School_Bell04-1.mp3")
//        mediaPlayer.setDataSource(
//            afdescripter.getFileDescriptor(),
//            afdescripter.getStartOffset(),
//            afdescripter.getLength()
//        )
//        mediaPlayer.prepare()
//        mediaPlayer.start()

        sound_but.setOnClickListener{
            sound.start()
        }

//        button.setOnClickListener{
//            val vibrator: Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//            vibrator.vibrate(300)
    }
}



package com.example.takumi.alarm

import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import android.widget.Spinner

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinner_H = findViewById<View>(R.id.spinner_Hour) as Spinner
        val spinner_M = findViewById<View>(R.id.spinner_Minute) as Spinner

        val adapter_H = ArrayAdapter.createFromResource(
            this,
            R.array.str_Hour, android.R.layout.simple_spinner_item
        )
        val adapter_M = ArrayAdapter.createFromResource(
            this,
            R.array.str_Minute, android.R.layout.simple_spinner_item
        )

        adapter_H.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter_M.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_H.adapter = adapter_H
        spinner_M.adapter = adapter_M

        val timer = TimerTask()
        timer.load(spinner_H, spinner_M)

        val sound = Music()
        sound.load(assets.openFd("Japanese_School_Bell04-1.mp3"))
        val vibrator: Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        timer.run(sound,vibrator)

        val stop_but:Button = findViewById(R.id.button)
        stop_but.setOnClickListener{
            sound.stop()
        }

    }
}



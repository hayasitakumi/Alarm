package com.example.takumi.alarm

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity

open class Music : AppCompatActivity() {
    val mediaPlayer = MediaPlayer()
    lateinit var afdescripter: AssetFileDescriptor

    open fun load(fd: AssetFileDescriptor) {
        afdescripter = fd
    }

    open fun start() {
        mediaPlayer.setDataSource(
            afdescripter.getFileDescriptor(),
            afdescripter.getStartOffset(),
            afdescripter.getLength()
        )
        mediaPlayer.prepare()
        mediaPlayer.start()
    }
}
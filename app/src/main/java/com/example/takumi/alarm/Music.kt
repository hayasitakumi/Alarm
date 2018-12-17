package com.example.takumi.alarm

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer

open class Music{
    val mediaPlayer = MediaPlayer()
    lateinit var afdescripter: AssetFileDescriptor

    open fun load(fd: AssetFileDescriptor) {
        afdescripter = fd
        mediaPlayer.setDataSource(
            afdescripter.getFileDescriptor(),
            afdescripter.getStartOffset(),
            afdescripter.getLength()
        )
        mediaPlayer.prepare()
    }

    open fun start() {
        mediaPlayer.start()
    }

    fun stop(){
        mediaPlayer.stop()
    }
}
package com.example.kashishmalhotra.room.utils

import android.app.Application
import com.example.kashishmalhotra.room.data.local.RoomDB

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initRoomDb()
    }

    private fun initRoomDb(){
        RoomDB.initInstance(this)
    }

}

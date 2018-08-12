package com.example.kashishmalhotra.room.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.kashishmalhotra.room.data.local.dao.NotesDao
import com.example.kashishmalhotra.room.db.dao.entities.Note
import android.arch.persistence.db.SupportSQLiteDatabase
import kotlin.concurrent.thread

@Database(entities = [(Note::class)], version = 1)
abstract class RoomDB : RoomDatabase() {


    abstract fun getNotesDao(): NotesDao

    companion object {

        @Volatile
        private var roomDB: RoomDB? = null

        fun initInstance(context: Context) =
                roomDB ?: synchronized(this) {
                    roomDB?: buildDatabase(context).also { roomDB = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        RoomDB::class.java, "RoomDB").addCallback(object : RoomDatabase.Callback() {
                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        //populateDB()
                    }
                }).build()

        private fun populateDB() {
            thread {
                roomDB?.getNotesDao()?.deleteAll()
                val note = Note("Water the plants daily")
                roomDB?.getNotesDao()?.insert(note)

            }
        }

        fun getInstance() = roomDB
    }


}
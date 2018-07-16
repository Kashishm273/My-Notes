package com.example.kashishmalhotra.room.data.remote

import com.example.kashishmalhotra.room.data.local.RoomDB
import com.example.kashishmalhotra.room.db.dao.entities.Note
import kotlin.concurrent.thread

class NotesRepository {

    private val notesDao = RoomDB.getInstance()?.getNotesDao()

    fun getAllWords() = notesDao?.getAllWords()

    fun addNote(note: Note) {
        thread { notesDao?.insert(note) }
    }
}
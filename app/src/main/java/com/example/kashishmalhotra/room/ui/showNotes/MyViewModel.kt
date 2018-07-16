package com.example.kashishmalhotra.room.ui.showNotes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.kashishmalhotra.room.data.remote.NotesRepository
import com.example.kashishmalhotra.room.db.dao.entities.Note

class MyViewModel : ViewModel(){

    private val notes : LiveData<List<Note>>?
    private val repository : NotesRepository = NotesRepository()

    init{
        notes = repository.getAllWords()
    }

    fun getAllWords() = notes

    fun addNote(note: Note){
        repository.addNote(note)
    }
}
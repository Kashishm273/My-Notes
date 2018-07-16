package com.example.kashishmalhotra.room.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Query
import com.example.kashishmalhotra.room.db.dao.entities.Note

@Dao
interface NotesDao : BaseDao<Note> {

    @Query("Select * from Note Order By name ASC")
    fun getAllWords() : LiveData<List<Note>>

    @Query("Delete from Note")
    fun deleteAll()

}
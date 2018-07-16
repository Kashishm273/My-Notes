package com.example.kashishmalhotra.room.data.local.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T)

    @Insert
    fun insertAll(vararg obj : T)

    @Delete
    fun delete(obj : T)

    @Update
    fun upadate(obj : T)

}
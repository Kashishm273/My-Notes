package com.example.kashishmalhotra.room.db.dao.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Note(@PrimaryKey val name : String)
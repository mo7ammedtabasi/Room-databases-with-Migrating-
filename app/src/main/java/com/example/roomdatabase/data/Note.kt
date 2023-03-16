package com.example.roomdatabase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "NOTE_TABLE")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id :Long,
    @ColumnInfo(name = "content")
    val content: String,
    val dateTime: Date,
    val isImportant: Boolean,
    val remindTimes : Int?
)

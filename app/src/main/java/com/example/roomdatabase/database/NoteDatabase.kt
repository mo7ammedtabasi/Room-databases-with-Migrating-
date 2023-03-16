package com.example.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roomdatabase.data.Note

@Database(entities = [Note::class], version = 4)
@TypeConverters(ConvertersData::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDoa(): NoteDao

    companion object {
        private const val DATABASE_NAME = "MyNoteDatabase"

        @Volatile
        private var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            return instance ?: synchronized(this) {
                buildDatabase(context).also {
                    instance = it
                }
            }
        }

        fun getInstanceWithoutContext(): NoteDatabase {
            return instance!!
        }

        private fun buildDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(context, NoteDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}
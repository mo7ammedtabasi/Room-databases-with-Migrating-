package com.example.roomdatabase.repository

import com.example.roomdatabase.data.Note
import com.example.roomdatabase.database.NoteDatabase

class NoteRepository {

    val dao = NoteDatabase.getInstanceWithoutContext().noteDoa()

    suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    fun getAllNote() = dao.getAllNotes()

    suspend fun getFilteredNote(searchTerm : String) = dao.getFilterNote("%$searchTerm%")
}
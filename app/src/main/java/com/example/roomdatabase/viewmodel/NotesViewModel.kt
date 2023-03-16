package com.example.roomdatabase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.Note
import com.example.roomdatabase.repository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.Date

class NotesViewModel: ViewModel() {

    val newNoteText = MutableLiveData<String>()
    val searchText = MutableStateFlow("")

    private val repository = NoteRepository()

    val notes = MutableLiveData<List<Note>>()

    init{
        addNote()
    }
    fun addNote() {
        viewModelScope.launch {
            repository.insertNote(Note(0, "test", Date(), false,5))
        }
    }

}
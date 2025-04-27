package com.NoteApp.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.NoteApp.models.Notes
import com.NoteApp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@RequiresApi(Build.VERSION_CODES.O)
class NotesViewModel @Inject constructor(val noteRepository: NoteRepository): ViewModel() {
    private var _notelist= MutableStateFlow<List<Notes>>(emptyList())
   var notelist = _notelist.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect{listData->
                _notelist.value=listData
            }
        }
    }

    fun addNotes(notes: Notes)=viewModelScope.launch { noteRepository.addNote(notes) }

    fun removeNotes(notes: Notes)=viewModelScope.launch { noteRepository.deleteNote(notes) }

    fun updateNote(notes: Notes)=viewModelScope.launch { noteRepository.updateNote(notes) }


}
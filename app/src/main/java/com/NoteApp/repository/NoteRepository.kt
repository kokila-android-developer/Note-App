package com.NoteApp.repository

import com.NoteApp.data.NoteDataBaseDao
import com.NoteApp.models.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDataBaseDao: NoteDataBaseDao) {
    suspend fun addNote(notes: Notes)=noteDataBaseDao.insertNote(notes)
    suspend fun updateNote(notes: Notes)=noteDataBaseDao.updateNote(notes)
    suspend fun deleteNote(notes: Notes)=noteDataBaseDao.deleteNote(notes)
    suspend fun deleteAllNotes()=noteDataBaseDao.deleteAll()
    suspend fun getNote(id:Int)=noteDataBaseDao.getNote(id)
    fun getAllNotes()=noteDataBaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}
package com.NoteApp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.NoteApp.models.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDataBaseDao {
    @Query("SELECT * from notes_table")
    fun getNotes():Flow<List<Notes>>

    @Query("SELECT * from notes_table WHERE id =:id")
   suspend fun getNote(id:Int):Notes

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(notes: Notes)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(notes: Notes)

    @Query("DELETE from notes_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(notes: Notes)

}
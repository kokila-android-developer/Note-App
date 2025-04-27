package com.NoteApp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.NoteApp.models.Notes
import com.NoteApp.util.DateConverter
import com.NoteApp.util.UUIDConverter

@Database(entities = [Notes::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDataBase : RoomDatabase(){
    abstract fun noteDao(): NoteDataBaseDao
}
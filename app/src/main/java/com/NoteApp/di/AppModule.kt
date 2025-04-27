package com.NoteApp.di

import android.content.Context
import androidx.room.Room
import com.NoteApp.data.NoteDataBase
import com.NoteApp.data.NoteDataBaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideNotesDataBaseDao(noteDataBase: NoteDataBase):NoteDataBaseDao=noteDataBase.noteDao()

    @Singleton
    @Provides
    fun provideNotesDataBase(@ApplicationContext context: Context):NoteDataBase
    = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        "notes_db"
    ).fallbackToDestructiveMigration(false).build()
}
package com.NoteApp.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.NoteApp.models.Notes

class NotesDataSource{

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadNotes():List<Notes>{
        return listOf(
            Notes(title = "Hai0", description = "Check description here , hello hai \n nice to you"),
            Notes(title = "Hai1", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai2", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai3", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai4", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai5", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai6", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai7", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai8", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai9", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai10", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai11", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai12", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai13", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai14", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai15", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai16", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai17", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai18", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai19", description = "Check description here , hello hai \n nice to you"),
//            Notes(title = "Hai20", description = "Check description here , hello hai \n nice to you"),
        )
    }
}
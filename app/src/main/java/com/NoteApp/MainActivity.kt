package com.NoteApp

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.NoteApp.screens.NoteScreen
import com.NoteApp.screens.NotesViewModel
import com.NoteApp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                val viewModels :NotesViewModel by viewModels()
                NotesDataSet(viewModels)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesDataSet(viewModel: NotesViewModel){
    Surface (modifier = Modifier.fillMaxSize(), color = Color.White){
        val notes=viewModel.notelist.collectAsState().value
        NoteScreen(note = notes,
            onAddNotes = {
                viewModel.addNotes(it)
            },
            onRemoveNotes = {
                Log.e("TAG", "NotesDataSet:remove $it ", )
                viewModel.removeNotes(it)
            })
    }

}


package com.NoteApp.screens

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.NoteApp.models.Notes
import com.NoteApp.R
import com.NoteApp.components.NoteButton
import com.NoteApp.components.NoteInputsFields
import com.NoteApp.data.NotesDataSource
import com.NoteApp.util.convertDateToTime

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NoteScreen(
    note:List<Notes> = NotesDataSource().loadNotes(),
    onAddNotes: (Notes) -> Unit ={},
    onRemoveNotes : (Notes) -> Unit ={}
){
    val keyboardController= LocalSoftwareKeyboardController.current

    var title by remember {
      mutableStateOf("")
  }
    var titleShowError by remember { mutableStateOf(false) }
    var description by remember {
        mutableStateOf("")
    }
    var descriptorShowError by remember { mutableStateOf(false) }


    var context=LocalContext.current
   Column(modifier = Modifier.padding(6.dp)) {
       TopAppBar(
           colors = TopAppBarDefaults.topAppBarColors(
               containerColor = Color(0xFFDADFE3),
               titleContentColor = Color.Black
           ),
           title = { Text(text = stringResource(R.string.app_name)) },
           actions ={Icon(imageVector = Icons.Default.Notifications, contentDescription = "", tint = Color.Black)} ,
       )
       Column(modifier = Modifier
           .fillMaxWidth()
           .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally)
       {
           NoteInputsFields(
               label = "Title",
               text = title,
               maxline = 1,
               imeAction = ImeAction.Next,
               onTextChanged = {
                  titleShowError=!it.all {char->
                       char.isWhitespace()||char.isLetter()
                   }
                   if(!titleShowError)title=it

               },
               errorMessage = "Title cannot be empty",
               isError = titleShowError
           )
           NoteInputsFields(
               modifier = Modifier.padding(bottom = 8.dp),
               label = "Add a note",
               text = description,
               maxline = 100,
               imeAction = ImeAction.Default ,
               onTextChanged = {
                   descriptorShowError = !it.all { char -> char.isWhitespace() || char.isLetter() }
                   if (!descriptorShowError) description = it
               },
               errorMessage = "Note cannot be empty",
               isError = descriptorShowError
           )

           NoteButton(
               onClick = {
                   if(title.isNotEmpty() && description.isNotEmpty()) {
                       onAddNotes(Notes(title = title, description = description))
                       title = ""
                       description = ""
                       Toast.makeText(context, "Notes added successfully", Toast.LENGTH_SHORT)
                           .show()
                       titleShowError=false
                       descriptorShowError=false
                   }else{
                       titleShowError=true
                       descriptorShowError=true
                   }
               },
               text = "Add",
               shape = RoundedCornerShape(20.dp),
               enabled = true,
               modifier = Modifier.width(100.dp)
           )


       }
       HorizontalDivider(modifier = Modifier
           .fillMaxWidth()
           .height(10.dp))
       LazyColumn {
           items(note){it->
               NoteRow(
                   it,
                   onNoteClicked = {
                       onRemoveNotes(it)
                   },
               )
           }
       }
   }
}
@SuppressLint("NewApi")
@Composable
fun NoteRow(notes: Notes,
            onNoteClicked: (Notes) -> Unit) {
    Surface(modifier = Modifier.fillMaxWidth().padding(top = 5.dp), shape = RoundedCornerShape(topEnd = 30.dp), color = Color(0xFFDFE6EB)) {
        Column(modifier = Modifier.fillMaxSize().padding(7.dp)
            .clickable {
                onNoteClicked(notes)
            },
            horizontalAlignment = Alignment.Start) {
            Text(text = notes.title, style = MaterialTheme.typography.titleMedium)
            Text(text = notes.description, style = MaterialTheme.typography.bodyMedium)
            Text(text = convertDateToTime(notes.entryDate))
        }
    }
    

}



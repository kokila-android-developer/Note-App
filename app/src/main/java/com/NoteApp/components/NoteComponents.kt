package com.NoteApp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import java.lang.Error
import java.security.MessageDigest


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteInputsFields(
    label:String,
    modifier: Modifier=Modifier,
    text:String,
    maxline:Int=1,
    onTextChanged: (String) -> Unit,
    imeAction: ImeAction,
    isError:Boolean=false,
    errorMessage:String=""
) {

    val keyboardController= LocalSoftwareKeyboardController.current
    Column (modifier = modifier.fillMaxWidth()){
        TextField(
            value = text,
            onValueChange = onTextChanged,
            label = { Text(label)},
            modifier = modifier.fillMaxWidth(),
            maxLines = maxline,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = imeAction
            ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color.Transparent, // Transparent background
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Gray, // Optional customization
                unfocusedIndicatorColor = Color.LightGray, // Optional customization
            )
        )
        if(isError&&errorMessage.isNotEmpty()){
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp, top = 2.dp)
            )
        }
    }

}


@Composable
fun NoteButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier=Modifier,
    shape: Shape,
    enabled:Boolean
){
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape
    ) {
        Text(text=text)
    }
}
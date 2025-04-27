package com.NoteApp.util

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
fun convertDateToTime(date: Date):String{
    Log.d("TAG", "convertDateToTime: ${date.time} ")
    val formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy hh:mm:ss a")
        .withZone(ZoneId.systemDefault()) // <-- very important!
    val formattedDate = formatter.format(date.toInstant())
    return formattedDate
}
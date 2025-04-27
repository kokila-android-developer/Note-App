package com.NoteApp.util

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun dateToTimeStamp(date: Date):Long{
        return date.time
    }

    @TypeConverter
    fun timeStampToDate(time:Long):Date{
        return Date(time)
    }
}
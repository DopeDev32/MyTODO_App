package com.example.mytodo_app.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.sql.Time
import java.util.Date

class Converter {

    @TypeConverter
    fun fromdata(date : Date ) : Long{
        return date.time
    }

    @TypeConverter
    fun toDate(time : Long) : Date {
        return Date(time)
    }
}
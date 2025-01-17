package com.example.mytodo_app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mytodo_app.todo


@Database(entities = [todo::class], version = 1)
@TypeConverters(Converter::class)
abstract class todoDataBase : RoomDatabase() {

    val NAME: String = "ToDo_DB"

//    companion object{
//        const val NAME = "ToDo_DB"
//    }

    abstract fun getodoDao() : todoDao
}
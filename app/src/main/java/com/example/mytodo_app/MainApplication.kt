package com.example.mytodo_app

import android.app.Application
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.example.mytodo_app.db.todoDataBase

class MainApplication : Application() {

    companion object{
        lateinit var todoDbs: todoDataBase
    }

    override fun onCreate() {
        super.onCreate()
        todoDbs = Room.databaseBuilder(
            context = applicationContext,
            todoDataBase::class.java,
            "ToDo_DB"
        ).build()
    }
}
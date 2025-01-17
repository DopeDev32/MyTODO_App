package com.example.mytodo_app.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mytodo_app.todo

@Dao
interface todoDao {

    @Query("SELECT * FROM TODO")
    fun getAlldata() : LiveData<List<todo>>


    @Insert
    fun addtodo(todo: todo)

    @Query("DELETE FROM TODO WHERE id = :id")
    fun deltodo(id : Int)
}
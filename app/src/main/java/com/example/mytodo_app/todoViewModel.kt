package com.example.mytodo_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class todoViewModel : ViewModel() {

    val todoDao = MainApplication.todoDbs.getodoDao()

    var todoList : LiveData<List<todo>> = todoDao.getAlldata()

    fun addTodo(title : String) {

        viewModelScope.launch(Dispatchers.IO){
            todoDao.addtodo(todo(title=title, createdAt = Date.from(Instant.now())))
        }

    }

    fun deltodo(id : Int){

        viewModelScope.launch(Dispatchers.IO){
            todoDao.deltodo(id)
        }

    }
}
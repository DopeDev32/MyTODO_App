//package com.example.mytodo_app
//
//import android.icu.text.CaseMap.Title
//import java.time.Instant
//import java.util.Date
//
//object todoManager {
//    private var todolist = mutableListOf<todo>()
//
//    fun getAllData() : List<todo>{
//        return todolist
//    }
//
//    fun addTodo(title: String) {
//        todolist.add(todo(System.currentTimeMillis().toInt(),title, Date.from(Instant.now())))
//    }
//
//    fun deltodo(id : Int){
//        todolist.removeIf {
//            it.id==id
//        }}
//
//    }

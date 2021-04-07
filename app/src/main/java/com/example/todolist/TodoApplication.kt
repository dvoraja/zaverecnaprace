package com.example.todolist

import android.app.Application

class TodoApplication : Application() {
    val database by lazy { TodoRoomDatabase.getDatabase(this)}
    val repository by lazy { TodoRepository(database.todoDao()) }
}
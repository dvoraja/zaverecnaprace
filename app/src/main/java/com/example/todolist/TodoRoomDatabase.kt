package com.example.todolist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Todo::class), version = 1, exportSchema = false)
public abstract class TodoRoomDatabase : RoomDatabase() {

    abstract fun todoDao() : TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoRoomDatabase? = null

        fun getDatabase(context: Context): TodoRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, TodoRoomDatabase::class.java, "todo_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}
package com.example.todolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo_table")
class Todo (@PrimaryKey @ColumnInfo(name = "title") val title: String, @ColumnInfo(name = "date") val date: String, @ColumnInfo(name = "category") val category: String, @ColumnInfo(name = "isDone") var isDone: Boolean = false)
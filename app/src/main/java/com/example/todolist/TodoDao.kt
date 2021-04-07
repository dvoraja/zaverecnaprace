package com.example.todolist

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_table ORDER BY title ASC")
    fun getAlphabetizedTodo(): Flow<MutableList<Todo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: Todo)

    @Delete
    suspend fun deleteTodos(todos: List<Todo>)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAll()
}
package com.example.todolist

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {

    val allTodo: LiveData<MutableList<Todo>> = repository.allTodo.asLiveData()

    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }
}

class TodoViewModelFactory(private val repository: TodoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(TodoViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
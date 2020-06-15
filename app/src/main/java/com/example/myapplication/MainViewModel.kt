package com.example.myapplication

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.User
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: ExampleRepository
) : ViewModel() {

    fun addUser() {
        viewModelScope.launch {
            repository.addUser()
        }
    }

    fun getAllUsers(): LiveData<List<User>> {
        return repository.getAllUsers()
    }

}


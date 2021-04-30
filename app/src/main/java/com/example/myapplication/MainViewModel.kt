package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.User
import com.example.myapplication.rest.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ExampleRepository
) : ViewModel() {

    private val mutableLiveData = MutableLiveData<List<Repo?>?>()
    val liveData: LiveData<List<Repo?>?> = mutableLiveData

    fun addUser() {
        viewModelScope.launch {
            repository.addUser()
        }
    }

    fun getAllUsers(): LiveData<List<User>> {
        return repository.getAllUsers()
    }

    fun getAllRepos() {
        viewModelScope.launch {
            mutableLiveData.postValue(repository.getGithubUserRepos())
        }
    }

}
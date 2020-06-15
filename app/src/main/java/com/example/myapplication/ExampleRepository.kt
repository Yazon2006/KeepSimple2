package com.example.myapplication

import androidx.lifecycle.LiveData
import com.example.myapplication.db.User
import com.example.myapplication.db.UserDao
import com.example.myapplication.rest.GitHubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val userDao: UserDao,
    private val gitHubService: GitHubService
) {

    suspend fun addUser() = withContext(Dispatchers.IO) {
        userDao.insertAll(User(firstName = "Max", lastName = "Motornyi"))
    }

    fun getAllUsers(): LiveData<List<User>> {
        return userDao.getAll()
    }

    suspend fun getGithubUserRepos() = withContext(Dispatchers.IO) {
        gitHubService.listRepos("Yazon2006")
    }
}
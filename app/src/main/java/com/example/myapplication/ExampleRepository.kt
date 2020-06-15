package com.example.myapplication

import androidx.lifecycle.LiveData
import com.example.myapplication.db.AppDatabase
import com.example.myapplication.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val appDatabase: AppDatabase
) {

    suspend fun addUser() = withContext(Dispatchers.IO) {
        appDatabase.userDao().insertAll(User(firstName = "Max", lastName = "Motornyi"))
    }

    fun getAllUsers(): LiveData<List<User>> {
        return appDatabase.userDao().getAll()
    }
}
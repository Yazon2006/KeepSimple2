package com.example.myapplication.db

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "database-name"
        ).build()
    }

    single {
        val appDatabase: AppDatabase = get()
        appDatabase.userDao()
    }

}
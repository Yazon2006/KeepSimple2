package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Use the 'by viewModels()' Kotlin property delegate
    // from the activity-ktx artifact
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addUserButton.setOnClickListener {
            mainViewModel.addUser()
        }
        getRepoButton.setOnClickListener {
            mainViewModel.getAllRepos()
        }

        mainViewModel.liveData.observe(this) {
            usersListTextView.text = it.toString()
        }

        mainViewModel.getAllUsers().observe(this) {
            usersListTextView.text = it.toString()
        }
    }
}
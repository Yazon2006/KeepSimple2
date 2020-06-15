package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

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

        mainViewModel.liveData.observe(this, Observer {
            usersListTextView.text = it.toString()
        })

        mainViewModel.getAllUsers().observe(this, Observer {
            usersListTextView.text = it.toString()
        })
    }
}
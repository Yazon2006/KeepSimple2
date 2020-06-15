package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.addUserButton)
        val textView = findViewById<TextView>(R.id.usersListTextView)

        button.setOnClickListener {
            mainViewModel.addUser()
        }

        mainViewModel.getAllUsers().observe(this, Observer {
            textView.text = it.toString()
        })
    }
}
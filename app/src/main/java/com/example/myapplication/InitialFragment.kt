package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.utils.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_initial.*

@AndroidEntryPoint
class InitialFragment : Fragment(R.layout.fragment_initial) {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addUserButton.setOnClickListener {
            mainViewModel.addUser()
        }

        nextScreen.setOnClickListener {
            navigate(R.id.action_initialFragment_to_detailsFragment)
        }

        getRepoButton.setOnClickListener {
            mainViewModel.getAllRepos()
        }

        mainViewModel.liveData.observe(viewLifecycleOwner) {
            usersListTextView.text = it.toString()
        }

        mainViewModel.getAllUsers().observe(viewLifecycleOwner) {
            usersListTextView.text = it.toString()
        }
    }

}
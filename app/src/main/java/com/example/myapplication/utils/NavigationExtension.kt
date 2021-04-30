package com.example.myapplication.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.R

fun Fragment.navigate(id: Int) {
    val navHostFragment =
        requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    navHostFragment.navController.navigate(id)
}
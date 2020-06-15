package com.example.myapplication.rest

import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<Repo?>?
}

data class Repo(
    val name: String,
    val full_name: String,
    val private: Boolean,
    val html_url: String,
    val description: String
)
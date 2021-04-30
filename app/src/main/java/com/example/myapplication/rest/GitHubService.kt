package com.example.myapplication.rest

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<Repo?>?
}

data class Repo(
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("private")
    val private: Boolean,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("description")
    val description: String
)
package com.example.android_githubclient_sample.apiservice

import com.example.android_githubclient_sample.entity.Project
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/repos")
    suspend fun getGitHubProjectList(@Path("user") user: String) : Response<List<Project>>
}
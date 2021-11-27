package com.example.android_githubclient_sample.repository

import com.example.android_githubclient_sample.entity.Project
import retrofit2.Response

interface ProjectRepository {
    suspend fun getProjectList(user: String): Response<List<Project>>
}
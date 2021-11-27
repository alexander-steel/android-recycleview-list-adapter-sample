package com.example.android_githubclient_sample.repository

import com.example.android_githubclient_sample.apiservice.GithubService
import com.example.android_githubclient_sample.entity.Project
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ProjectRepositoryImpl : ProjectRepository {

    private val BASEURL = "https://api.github.com/"
    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

    private var githubService: GithubService =
        retrofit.create(GithubService::class.java)

    override suspend fun getProjectList(user: String): Response<List<Project>> {
        return githubService.getGitHubProjectList(user)
    }

    companion object Factory {

        val instance: ProjectRepositoryImpl
            @Synchronized get() {
                return ProjectRepositoryImpl()
            }
    }
}
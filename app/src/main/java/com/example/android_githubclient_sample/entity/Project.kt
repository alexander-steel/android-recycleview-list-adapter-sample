package com.example.android_githubclient_sample.entity

data class Project(
    val id: Long,
    var name: String,
    var full_name: String,
    val html_url: String
)
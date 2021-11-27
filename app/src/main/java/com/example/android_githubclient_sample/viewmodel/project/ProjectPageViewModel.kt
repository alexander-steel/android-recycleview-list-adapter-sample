package com.example.android_githubclient_sample.viewmodel.project

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_githubclient_sample.entity.Project
import com.example.android_githubclient_sample.repository.ProjectRepositoryImpl
import kotlinx.coroutines.launch


class ProjectPageViewModel :
    ViewModel() {

    private val projectRepository = ProjectRepositoryImpl.instance

    private val _projects: MutableLiveData<List<Project>> = MutableLiveData()

    val projects: LiveData<List<Project>> get() = _projects

    init {
        Log.i("ProjectPageViewModel", "MainPageViewModel Created")
        loadProjectList("{your github account}}")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ProjectPageViewModel", "MainPageViewModel Destroyed")
    }


    private fun loadProjectList(user: String) {
        viewModelScope.launch {
            try {
                val request = projectRepository.getProjectList(user)
                print("request.isSuccessful" + request.isSuccessful)
                if (request.isSuccessful) {
                    _projects.postValue(request.body())
                }
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }
}
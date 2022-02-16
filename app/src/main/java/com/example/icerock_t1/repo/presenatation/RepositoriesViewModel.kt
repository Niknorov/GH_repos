package com.example.icerock_t1.repo.presenatation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.repo.domain.GetRepositoriesUseCase
import com.example.icerock_t1.repo.domain.RepositoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositoriesViewModel(
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) : ViewModel() {


    private val _repositoriesLiveData = MutableLiveData<List<RepositoryModel>>()
    val repositoriesLiveData: LiveData<List<RepositoryModel>> = _repositoriesLiveData

    fun getRepositories(userName: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _repositoriesLiveData.postValue(getRepositoriesUseCase(userName = userName)!!)
            }
        }
    }
}
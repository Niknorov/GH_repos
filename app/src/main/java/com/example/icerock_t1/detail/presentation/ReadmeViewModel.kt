package com.example.icerock_t1.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.detail.domain.GetReadmeUseCase
import com.example.icerock_t1.detail.domain.ReadmeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReadmeViewModel(
    private val getReadmeUseCase: GetReadmeUseCase
) : ViewModel() {

    private val _readmeLiveData = MutableLiveData<List<ReadmeModel>>()
    val readmeLiveData: LiveData<List<ReadmeModel>> = _readmeLiveData

    fun getReadme(repoName: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _readmeLiveData.postValue(getReadmeUseCase(repoName = repoName)!!)
            }
        }
    }
}
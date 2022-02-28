package com.example.icerock_t1.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.detail.domain.GetReadmeUseCase
import com.example.icerock_t1.detail.domain.GetRepositoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReadmeViewModel(
    private val getReadmeUseCase: GetReadmeUseCase,
    private val getRepositoryUseCase: GetRepositoryUseCase
) : ViewModel() {

    private val _readmeLiveData = MutableLiveData<List<RepositoryDetailItem>>()
    val readmeLiveData: LiveData<List<RepositoryDetailItem>> = _readmeLiveData

    fun getDetail(repoName: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val readmeModel = getReadmeUseCase(repoName)
                val readmeItem =
                    RepositoryDetailItem.ReadmeItem(
                        content = readmeModel.content
                    )
                val repositoryModel = getRepositoryUseCase(repoName)
                val statsItem =
                    RepositoryDetailItem.StatsItem(
                        stargazersCount = repositoryModel.stargazersCount,
                        forksCount = repositoryModel.forksCount,
                        watchersCount = repositoryModel.watchersCount,
                        license = "",
                        url = repositoryModel.url
                    )


                val repositoryDetailItem: List<RepositoryDetailItem> = listOf(readmeItem, statsItem)
                _readmeLiveData.postValue(repositoryDetailItem)
            }

        }


    }
}


package com.example.icerock_t1.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.detail.domain.GetReadmeUseCase
import com.example.icerock_t1.repo.domain.GetRepositoriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReadmeViewModel(
    private val getReadmeUseCase: GetReadmeUseCase,
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) : ViewModel() {

    private val _readmeLiveData = MutableLiveData<List<RepositoryDetailItem>>()
    val readmeLiveData: LiveData<List<RepositoryDetailItem>> = _readmeLiveData

    fun getReadme(repoName: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val readmeModel = getReadmeUseCase(repoName)
                val readmeItem = readmeModel.map {
                    RepositoryDetailItem.ReadmeItem(
                        content = it.content
                    )
                }
                val repositoryModel = getRepositoriesUseCase()
                val statsItem = repositoryModel.map {
                    RepositoryDetailItem.StatsItem(
                        stargazersCount = it.stargazersCount,
                        forksCount = it.forksCount,
                        watchersCount = it.watchersCount,
                        license = "",
                        url = it.url
                    )
                }

                val repositoryDetailItem: List<RepositoryDetailItem> = readmeItem + statsItem

                _readmeLiveData.postValue(repositoryDetailItem)
            }
        }
    }
}
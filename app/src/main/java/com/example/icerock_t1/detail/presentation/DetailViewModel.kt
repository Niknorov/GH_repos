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
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class DetailViewModel(
    private val getReadmeUseCase: GetReadmeUseCase,
    private val getRepositoryUseCase: GetRepositoryUseCase
) : ViewModel() {

    private val _detailLiveData = MutableLiveData<DetailUiState>()
    val detailLiveData: LiveData<DetailUiState> = _detailLiveData

    fun getDetail(repoName: String) {
        viewModelScope.launch {
            try {
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


                    val repositoryDetailItem: List<RepositoryDetailItem> =
                        listOf(statsItem, readmeItem)
                    _detailLiveData.postValue(DetailUiState.Success(repositoryDetailItem))
                }

            } catch (unknownHostException: UnknownHostException) {
                _detailLiveData.postValue(DetailUiState.ErrorNetwork)
            } catch (socketTimeoutException: SocketTimeoutException) {
                _detailLiveData.postValue(DetailUiState.ErrorNetwork)
            } catch (httpException: HttpException) {

                if (httpException.code() == 404) {

                    val repositoryModel = getRepositoryUseCase(repoName)
                    val statsItem =
                        RepositoryDetailItem.StatsItem(
                            stargazersCount = repositoryModel.stargazersCount,
                            forksCount = repositoryModel.forksCount,
                            watchersCount = repositoryModel.watchersCount,
                            license = "",
                            url = repositoryModel.url
                        )

                    val repositoryDetailItem: List<RepositoryDetailItem> =
                        listOf(statsItem)
                    _detailLiveData.postValue(DetailUiState.HttpError(repositoryDetailItem))
                }

            }
        }


    }
}


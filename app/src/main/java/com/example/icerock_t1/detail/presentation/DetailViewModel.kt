package com.example.icerock_t1.detail.presentation

import android.util.Base64
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.detail.domain.GetLicenseUseCase
import com.example.icerock_t1.detail.domain.GetReadmeUseCase
import com.example.icerock_t1.detail.domain.GetRepositoryUseCase
import com.example.icerock_t1.user.domain.ClearUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getReadmeUseCase: GetReadmeUseCase,
    private val getRepositoryUseCase: GetRepositoryUseCase,
    private val getLicenseUseCase: GetLicenseUseCase,
    private val clearUserUseCase: ClearUserUseCase
) : ViewModel() {

    private val _detailLiveData = MutableLiveData<DetailUiState>()
    val detailLiveData: LiveData<DetailUiState> = _detailLiveData

    private suspend fun getLicense(repoName: String): String {

        return try {
            val license = getLicenseUseCase(repoName)
            license.name
        } catch (httpException: HttpException) {
            "-/-"
        }
    }

    private suspend fun getReadme(repoName: String): String {

        return try {
            val readme = getReadmeUseCase(repoName)
            Base64.decode(readme.content, Base64.DEFAULT).toString(Charsets.UTF_8)

        } catch (httpException: HttpException) {
            ""
        }
    }


    fun getDetail(repoName: String) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val repositoryModel = getRepositoryUseCase(repoName)
                    val readmeItem =
                        RepositoryDetailItem.ReadmeItem(
                            content = getReadme(repoName)
                        )
                    val statsItem =
                        RepositoryDetailItem.StatsItem(
                            stargazersCount = repositoryModel.stargazersCount,
                            forksCount = repositoryModel.forksCount,
                            watchersCount = repositoryModel.watchersCount,
                            license = getLicense(repoName),
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
            }
        }

    }

    fun onExit() {
        clearUserUseCase()
    }

}


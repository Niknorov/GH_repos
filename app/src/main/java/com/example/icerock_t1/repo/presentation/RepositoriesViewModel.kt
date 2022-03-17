package com.example.icerock_t1.repo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.repo.domain.GetRepositoriesUseCase
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
class RepositoriesViewModel @Inject constructor(
    private val getRepositoriesUseCase: GetRepositoriesUseCase,
    private val clearUserUseCase: ClearUserUseCase
) : ViewModel() {


    private val _repositoriesLiveData = MutableLiveData<RepoUiState>()
    val repositoriesLiveData: LiveData<RepoUiState> = _repositoriesLiveData

    fun getRepositories() {
        viewModelScope.launch {

            try {
                withContext(Dispatchers.IO) {
                    val repositoriesList = getRepositoriesUseCase()
                    _repositoriesLiveData.postValue(RepoUiState.Success(repositoriesList))
                    if (repositoriesList.isEmpty()) {
                        _repositoriesLiveData.postValue(RepoUiState.EmptyRepos)
                    }
                }
            } catch (unknownHostException: UnknownHostException) {
                _repositoriesLiveData.postValue(RepoUiState.ErrorNetwork)
            } catch (socketTimeoutException: SocketTimeoutException) {
                _repositoriesLiveData.postValue(RepoUiState.ErrorNetwork)
            } catch (httpException: HttpException) {
                if (httpException.code() == 404) {
                    _repositoriesLiveData.postValue(RepoUiState.HttpException)
                }
            }

        }
    }

    fun onExit() {
        clearUserUseCase()
    }

}
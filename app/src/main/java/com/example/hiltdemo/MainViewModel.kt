package com.example.hiltdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getArticleUseCase: GetArticleUseCase,
) : ViewModel() {
    private val _newsState = MutableStateFlow<UiState>(UiState.Loading)
    val newsState: StateFlow<UiState> get() = _newsState

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            _newsState.value = UiState.Loading
            getArticleUseCase()
                .onFailure { e ->
                    _newsState.value = UiState.Error(e.message ?: "Error")
                }
                .onSuccess { response ->
                    _newsState.value = UiState.Success(response)
                }
        }
    }
}


sealed class UiState {
    data object Loading : UiState()
    data class Success(val data: List<Article>) : UiState()
    data class Error(val message: String) : UiState()
}
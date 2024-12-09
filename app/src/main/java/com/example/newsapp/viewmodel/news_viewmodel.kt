package com.example.newsapp.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.NewsModel
import com.example.newsapp.repository.NewsRetrofit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class newsviewmodel:ViewModel(){
    private val _newsList = MutableStateFlow<NewsModel?>(null)
    val newsList: StateFlow<NewsModel?> = _newsList
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    val errorMessage= mutableStateOf<String?>(null)
    private val Apiservice=NewsRetrofit.ApiServices
    fun fetchData(key:String,query:String){
        viewModelScope.launch {
            _isLoading.value=true
            try {
                val res=Apiservice.getNews(key,query)
                Log.d("Status code is " , res.code().toString())
                if (res.isSuccessful) {
                    val responseBody = res.body()
                    if (responseBody != null) {
                        _newsList.value = responseBody
                        Log.d("Data Fetched", newsList.value.toString())
                    } else {
                        errorMessage.value = "Error: Response body is null"
                        Log.d("Error", "Response body is null")
                    }
                } else {
                    errorMessage.value = "Error: ${res.errorBody()?.string() ?: "Unknown error"}"
                    Log.d("Error", res.errorBody()?.string() ?: "Unknown error")
                }}
            catch (e: Exception) {
                errorMessage.value = "Exception: ${e.localizedMessage ?: "Unknown error"}"
                Log.e("NewsViewModel", "Exception: ${e.localizedMessage}")
            } finally {
                _isLoading.value = false
                Log.d("NewsViewModel", "Data fetching completed")
            }

        }
    }

}
package com.example.picsumapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.picsumapp.model.Post
import com.example.picsumapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * This the MainViewModel
 */
class MainViewModel(
    private val repository: Repository,
) : ViewModel() {


    val myResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    //SEND REQUEST TO API
    fun getPosts() {
        viewModelScope.launch {
            val response = repository.getPosts()
            myResponse.value = response
        }
    }
}
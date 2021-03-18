package com.example.picsumapp.repository

import com.example.picsumapp.api.RetrofitInstance
import com.example.picsumapp.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPosts(): Response<List<Post>> {
       return RetrofitInstance.api.getPosts()
    }
}
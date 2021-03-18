package com.example.picsumapp.api

import com.example.picsumapp.model.Post
import retrofit2.Response
import retrofit2.http.GET

/**
 * RETROFIT POST API INTERFACE
 */
interface PostApi {

    //GET THE RESPONSE FROM URL AND STORE AS A LIST OF POSTS
    @GET("list")
    suspend fun getPosts():Response<List<Post>>

}
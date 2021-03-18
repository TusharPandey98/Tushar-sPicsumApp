package com.example.picsumapp.model
import com.google.gson.annotations.SerializedName

/**
 * POST MODEL CLASS
 */
data class Post(
    @SerializedName("author")
    val author: String,
    @SerializedName("id")
    val id: Int
)
package com.example.githubuserapp.network

import com.example.githubuserapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/user")
    @Headers("Authorization : token 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")
    fun getSearchUsers(@Query("q") query: String) : Call<UserResponse>
}
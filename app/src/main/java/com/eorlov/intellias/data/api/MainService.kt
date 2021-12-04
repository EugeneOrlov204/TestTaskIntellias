package com.eorlov.intellias.data.api

import com.eorlov.intellias.domain.entities.Words
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface MainService {
    @GET("api/v2/entries/en/{word}")
    suspend fun getWord(@Path("word") word: String): Response<Words>
}
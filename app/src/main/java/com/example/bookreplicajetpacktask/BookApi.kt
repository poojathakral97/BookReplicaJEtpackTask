package com.example.bookreplicajetpacktask

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BookApi {
    @GET("books")
    suspend fun getBooks(): Response<List<Book>>
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://acharyaprashant.org/api/v2/legacy/books/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val bookApi = retrofit.create(BookApi::class.java)

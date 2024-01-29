package com.example.bookreplicajetpacktask

import retrofit2.Response

class BookRepository(private val bookApi: BookApi) {
    suspend fun getBooks(): Response<List<Book>> {
        return bookApi.getBooks()
    }
}
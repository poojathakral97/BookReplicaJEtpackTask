package com.example.bookreplicajetpacktask

import retrofit2.Response

class BookRepository(private val bookApi: BookApi) {
    suspend fun getAllBooks(): List<Book> {

        return try {
            bookApi.getAllBooks()
        } catch (e: Exception) {
            // Handle errors gracefully
            e.printStackTrace()
            emptyList()
        }
    }

}

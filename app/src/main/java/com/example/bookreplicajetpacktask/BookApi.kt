package com.example.bookreplicajetpacktask

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

class BookApi {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                // Configure KotlinxSerialization if needed
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getAllBooks(): List<Book> {
        return client.get("https://acharyaprashant.org/api/v2/legacy/books/")
    }
}

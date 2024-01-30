package com.example.bookreplicajetpacktask

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Simple data class to represent a Book entity
//data class Book(val id: String, val title: String, val author: String)
@Serializable
data class Book(
    @SerialName("id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("author") val author: String
)
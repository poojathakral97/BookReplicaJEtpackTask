package com.example.bookreplicajetpacktask.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.bookreplicajetpacktask.Book // Ensure the correct import for Book data class

@Composable
fun Greeting(name: String, books: List<Book>) {
    Column {
        Text(text = "Hello, $name!")

        LazyColumn {
            items(books) { book ->
                Text(text = "${book.title} by ${book.author}")
            }
        }
    }
}
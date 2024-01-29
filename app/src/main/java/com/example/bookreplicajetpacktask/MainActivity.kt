package com.example.bookreplicajetpacktask

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookreplicajetpacktask.ui.theme.BookReplicaJEtpackTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookReplicaJEtpackTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val bookViewModel: BookViewModel = viewModel(
                        factory = BookViewModelFactory(BookRepository(bookApi))
                    )

                    BookListScreen(bookViewModel = bookViewModel)
                }
            }
        }
    }
}

@Composable
fun BookListScreen(bookViewModel: BookViewModel = viewModel()) {
    // Observe the books state
    val books by remember { bookViewModel.books }

    Column {
        Text(text = "Books List")

        if (books.isNotEmpty()) {
            LazyColumn {
                items(books) { book ->
                    Text(text = "${book.title} by ${book.author}")
                }
            }
        } else {
            Text(text = "No books available")
        }
    }

    // Trigger the data fetch when the screen is first shown
    DisposableEffect(Unit) {
        bookViewModel.fetchBooks()
        onDispose { }
    }
}
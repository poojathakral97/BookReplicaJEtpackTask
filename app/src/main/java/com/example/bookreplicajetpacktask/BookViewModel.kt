package com.example.bookreplicajetpacktask
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {
    private val _books = mutableStateOf<List<Book>>(emptyList())
    val books: State<List<Book>> = _books

    fun fetchBooks() {
        viewModelScope.launch {
            try {
                _books.value = repository.getBooks()
            } catch (e: Exception) {
                Log.e("ViewModel", "Failed to fetch books", e)
            }
        }
    }
    }


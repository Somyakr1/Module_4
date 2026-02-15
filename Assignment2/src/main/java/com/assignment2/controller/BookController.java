package com.assignment2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.assignment2.entity.Book;
import com.assignment2.service.BookService;

public class BookController {
	private BookService bookService;

	@GetMapping
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable Integer id) {
		return bookService.deleteBook(id);
	}
}

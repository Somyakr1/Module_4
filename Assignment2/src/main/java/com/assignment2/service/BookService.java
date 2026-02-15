package com.assignment2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.assignment2.entity.Book;

@Service
public class BookService {
	private List<Book> books = new ArrayList<>();

    @PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
    public List<Book> getAllBooks() {
        return books;
    }

    @PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    @PreAuthorize("hasRole('TEACHER')")
    public String deleteBook(Integer id) {
        books.removeIf(book -> book.getId().equals(id));
        return "Book deleted successfully";
    }
}

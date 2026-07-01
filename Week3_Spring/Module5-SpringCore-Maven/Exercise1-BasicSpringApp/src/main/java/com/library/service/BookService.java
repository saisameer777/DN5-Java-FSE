package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String book) {
        System.out.println("BookService: adding book");
        bookRepository.save(book);
    }

    public String getBook(int id) {
        System.out.println("BookService: fetching book");
        return bookRepository.findById(id);
    }
}

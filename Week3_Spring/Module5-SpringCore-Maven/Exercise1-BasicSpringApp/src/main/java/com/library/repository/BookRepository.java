package com.library.repository;

public class BookRepository {

    public void save(String book) {
        System.out.println("BookRepository: saving book - " + book);
    }

    public String findById(int id) {
        System.out.println("BookRepository: finding book with id " + id);
        return "Book-" + id;
    }
}

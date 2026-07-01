package com.library.repository;

public class BookRepository {

    public void save(String book) {
        System.out.println("BookRepository: saving - " + book);
    }

    public String findById(int id) {
        return "Book-" + id;
    }
}

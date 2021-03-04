package com.app.service;

import com.app.model.Book;
import com.app.service.exception.BookIsNotExisted;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Integer id);

    void borrowBook(Book book) throws BookIsNotExisted;

    void returnBook()
}

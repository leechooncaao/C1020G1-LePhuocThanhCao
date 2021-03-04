package com.app.service.impl;

import com.app.model.Book;
import com.app.repository.BookRepository;
import com.app.service.BookService;
import com.app.service.exception.BookIsNotExisted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrowBook(Book book) throws BookIsNotExisted {
        book.setQuantity(book.getQuantity() -1);

        if(book.getQuantity() <= 0)
            throw new BookIsNotExisted("Book is not existed");
    }
}

package com.example.bookauthorapp.service;

import com.example.bookauthorapp.model.Book;
import com.example.bookauthorapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public Book save(Book book) {
    return bookRepository.save(book);
  }

  public Book findById(Long id) {
    return bookRepository.findById(id).orElse(null);
  }

  public List<Object[]> findBooksWithAuthors() {
    return bookRepository.findBooksWithAuthors();
  }
}

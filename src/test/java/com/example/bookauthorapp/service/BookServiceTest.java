package com.example.bookauthorapp.service;

import com.example.bookauthorapp.model.Book;
import com.example.bookauthorapp.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BookServiceTest {

  @Mock
  private BookRepository bookRepository;

  @InjectMocks
  private BookService bookService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void findAll() {
    List<Book> books = Arrays.asList(new Book(), new Book());
    when(bookRepository.findAll()).thenReturn(books);
    assertEquals(2, bookService.findAll().size());
  }

  @Test
  void save() {
    Book book = new Book();
    when(bookRepository.save(any(Book.class))).thenReturn(book);
    assertEquals(book, bookService.save(book));
  }

  @Test
  void findById() {
    Book book = new Book();
    when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
    assertEquals(book, bookService.findById(1L));
  }

  @Test
  void findByIdNotFound() {
    when(bookRepository.findById(1L)).thenReturn(Optional.empty());
    assertNull(bookService.findById(1L));
  }

  @Test
  void findBooksWithAuthors() {
    List<Object[]> data = Arrays.<Object[]>asList(new Object[]{"Title", "Name"});
    when(bookRepository.findBooksWithAuthors()).thenReturn(data);
    assertEquals(1, bookService.findBooksWithAuthors().size());
  }
}

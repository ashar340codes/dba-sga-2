package com.example.bookauthorapp.service;

import com.example.bookauthorapp.model.Author;
import com.example.bookauthorapp.repository.AuthorRepository;
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

class AuthorServiceTest {

  @Mock
  private AuthorRepository authorRepository;

  @InjectMocks
  private AuthorService authorService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void findAll() {
    List<Author> authors = Arrays.asList(new Author(), new Author());
    when(authorRepository.findAll()).thenReturn(authors);
    assertEquals(2, authorService.findAll().size());
  }

  @Test
  void save() {
    Author author = new Author();
    when(authorRepository.save(any(Author.class))).thenReturn(author);
    assertEquals(author, authorService.save(author));
  }

  @Test
  void findById() {
    Author author = new Author();
    when(authorRepository.findById(1L)).thenReturn(Optional.of(author));
    assertEquals(author, authorService.findById(1L));
  }

  @Test
  void findByIdNotFound() {
    when(authorRepository.findById(1L)).thenReturn(Optional.empty());
    assertNull(authorService.findById(1L));
  }
}

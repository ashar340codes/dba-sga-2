package com.example.bookauthorapp.service;

import com.example.bookauthorapp.model.Author;
import com.example.bookauthorapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  public Author save(Author author) {
    return authorRepository.save(author);
  }

  public Author findById(Long id) {
    return authorRepository.findById(id).orElse(null);
  }
}

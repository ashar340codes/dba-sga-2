package com.example.bookauthorapp.repository;

import com.example.bookauthorapp.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.example.bookauthorapp.service.AuthorService;
import com.example.bookauthorapp.service.BookService;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({AuthorService.class, BookService.class})
class AuthorRepositoryTest {

  @Autowired
  private AuthorRepository authorRepository;

  @Test
  void saveAndFindAuthor() {
    Author author = new Author();
    author.setName("Test Author");
    author.setBiography("Test Bio");

    Author saved = authorRepository.save(author);
    assertThat(saved.getId()).isNotNull();

    Author found = authorRepository.findById(saved.getId()).orElse(null);
    assertThat(found).isNotNull();
    assertThat(found.getName()).isEqualTo("Test Author");
  }
}

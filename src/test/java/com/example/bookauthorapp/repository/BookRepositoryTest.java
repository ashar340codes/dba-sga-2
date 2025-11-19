package com.example.bookauthorapp.repository;

import com.example.bookauthorapp.model.Author;
import com.example.bookauthorapp.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import com.example.bookauthorapp.service.AuthorService;
import com.example.bookauthorapp.service.BookService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({AuthorService.class, BookService.class})
class BookRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private BookRepository bookRepository;

  @Test
  void saveAndFindBook() {
    Author author = new Author();
    author.setName("Test Author");
    entityManager.persist(author);

    Book book = new Book();
    book.setTitle("Test Book");
    book.setGenre("Test Genre");
    book.setAuthor(author);

    Book saved = bookRepository.save(book);
    assertThat(saved.getId()).isNotNull();

    Book found = bookRepository.findById(saved.getId()).orElse(null);
    assertThat(found).isNotNull();
    assertThat(found.getTitle()).isEqualTo("Test Book");
  }

  @Test
  void findBooksWithAuthors() {
    Author author = new Author();
    author.setName("Test Author");
    entityManager.persist(author);

    Book book = new Book();
    book.setTitle("Test Book");
    book.setGenre("Test Genre");
    book.setAuthor(author);
    entityManager.persist(book);

    List<Object[]> result = bookRepository.findBooksWithAuthors();
    assertThat(result).isNotEmpty();
    assertThat(result).anySatisfy(row -> {
      assertThat(row[0]).isEqualTo("Test Book");
      assertThat(row[1]).isEqualTo("Test Author");
    });
  }
}

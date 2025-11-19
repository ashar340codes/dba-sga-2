package com.example.bookauthorapp;

import com.example.bookauthorapp.model.Author;
import com.example.bookauthorapp.model.Book;
import com.example.bookauthorapp.service.AuthorService;
import com.example.bookauthorapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookAuthorAppApplication implements CommandLineRunner {

  @Autowired
  private AuthorService authorService;

  @Autowired
  private BookService bookService;

  public static void main(String[] args) {
    SpringApplication.run(BookAuthorAppApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    if (authorService.findAll().isEmpty()) {
      for (int i = 1; i <= 10; i++) {
        Author author = new Author();
        author.setName("Author " + i);
        author.setBiography("Biography of Author " + i);
        authorService.save(author);
      }

      for (int i = 1; i <= 10; i++) {
        Book book = new Book();
        book.setTitle("Book " + i);
        book.setGenre("Genre " + i);
        book.setAuthor(authorService.findById((long) ((i - 1) % 10 + 1)));
        bookService.save(book);
      }
    }
  }
}

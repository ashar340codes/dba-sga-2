package com.example.bookauthorapp.repository;

import com.example.bookauthorapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

  @Query("SELECT b.title, a.name FROM Book b INNER JOIN b.author a")
  List<Object[]> findBooksWithAuthors();
}

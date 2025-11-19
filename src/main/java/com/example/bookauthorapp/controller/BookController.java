package com.example.bookauthorapp.controller;

import com.example.bookauthorapp.model.Book;
import com.example.bookauthorapp.service.AuthorService;
import com.example.bookauthorapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @Autowired
  private AuthorService authorService;

  @GetMapping
  public String listBooks(Model model) {
    model.addAttribute("books", bookService.findAll());
    model.addAttribute("joinedData", bookService.findBooksWithAuthors());
    return "books";
  }

  @GetMapping("/new")
  public String showCreateForm(Model model) {
    model.addAttribute("book", new Book());
    model.addAttribute("authors", authorService.findAll());
    return "book-form";
  }

  @PostMapping
  public String saveBook(@ModelAttribute Book book, Model model) {
    try {
      bookService.save(book);
      return "redirect:/books";
    } catch (Exception e) {
      model.addAttribute("error", "Error saving book: " + e.getMessage());
      model.addAttribute("authors", authorService.findAll());
      return "book-form";
    }
  }

  @GetMapping("/edit/{id}")
  public String showUpdateForm(@PathVariable Long id, Model model) {
    Book book = bookService.findById(id);
    if (book == null) {
      return "redirect:/books";
    }
    model.addAttribute("book", book);
    model.addAttribute("authors", authorService.findAll());
    return "book-form";
  }

  @PostMapping("/edit/{id}")
  public String updateBook(@PathVariable Long id, @ModelAttribute Book book, Model model) {
    try {
      book.setId(id);
      bookService.save(book);
      return "redirect:/books";
    } catch (Exception e) {
      model.addAttribute("error", "Error updating book: " + e.getMessage());
      model.addAttribute("authors", authorService.findAll());
      return "book-form";
    }
  }

  @PostMapping("/new")
  public String createBookViaNew(@ModelAttribute Book book, Model model) {
    return saveBook(book, model);
  }
}

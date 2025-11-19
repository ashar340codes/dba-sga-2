package com.example.bookauthorapp.controller;

import com.example.bookauthorapp.model.Author;
import com.example.bookauthorapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

  @Autowired
  private AuthorService authorService;

  @GetMapping
  public String listAuthors(Model model) {
    model.addAttribute("authors", authorService.findAll());
    return "authors";
  }

  @GetMapping("/new")
  public String showCreateForm(Model model) {
    model.addAttribute("author", new Author());
    return "author-form";
  }

  @PostMapping
  public String saveAuthor(@ModelAttribute Author author, Model model) {
    try {
      authorService.save(author);
      return "redirect:/authors";
    } catch (Exception e) {
      model.addAttribute("error", "Error saving author: " + e.getMessage());
      return "author-form";
    }
  }

  @GetMapping("/edit/{id}")
  public String showUpdateForm(@PathVariable Long id, Model model) {
    Author author = authorService.findById(id);
    if (author == null) {
      return "redirect:/authors";
    }
    model.addAttribute("author", author);
    return "author-form";
  }
}

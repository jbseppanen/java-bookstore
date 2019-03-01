package com.lambdaschool.javabookstore.controllers;

import com.lambdaschool.javabookstore.models.Author;
import com.lambdaschool.javabookstore.models.Book;
import com.lambdaschool.javabookstore.repositories.AuthorRepository;
import com.lambdaschool.javabookstore.repositories.BookRepository;
import com.lambdaschool.javabookstore.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepository authorRepo;

    @Autowired
    SectionRepository sectionRepo;

    @PutMapping(value = "/books/{id}")
    public Book updateBookById(@PathVariable long id, @RequestBody Book book) throws URISyntaxException {
        Optional<Book> foundBook = bookRepo.findById(id);
        if (foundBook.isPresent()) {
            book.setBookid(id);
            bookRepo.save(book);
            return book;
        } else {
            return null;
        }
    }

    @PostMapping(value = "/books/authors/{id}")
    public Book assignAuthorToBook(@RequestBody Book book, @PathVariable long id) throws URISyntaxException {
        Optional<Book> foundBook = bookRepo.findById(book.getBookid());
        Optional<Author> foundAuthor = authorRepo.findById(id);
        if (foundBook.isPresent() & foundAuthor.isPresent()) {
            Book bookFromRepo = foundBook.get();
            bookFromRepo.getAuthors().add(foundAuthor.get());
            bookRepo.save(bookFromRepo);
            return bookFromRepo;
        } else {
            return null;
        }
    }

    @SuppressWarnings("Duplicates")
    @DeleteMapping(value = "/books/{id}")
    public Book deleteBookById(@PathVariable long id) {
        Optional<Book> foundBook = bookRepo.findById(id);
        if (foundBook.isPresent()) {
            Book book = foundBook.get();
            book.getAuthors().clear();
            bookRepo.save(book);
            bookRepo.deleteById(id);
            return foundBook.get();
        } else {
            return null;
        }
    }
}
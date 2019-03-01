package com.lambdaschool.javabookstore.controllers;

import com.lambdaschool.javabookstore.models.Author;
import com.lambdaschool.javabookstore.models.Book;
import com.lambdaschool.javabookstore.repositories.AuthorRepository;
import com.lambdaschool.javabookstore.repositories.BookRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepository authorRepo;

    @ApiOperation(value = "Returns a list of all books.", response = List.class)
    @GetMapping(value = "")
    public List<Book> listAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping(value = "/id/{id}")
    public Book getBookById(@PathVariable long id) {
        Optional<Book> foundBook = bookRepo.findById(id);
        return foundBook.orElse(null);
    }

    @GetMapping(value = "/name/{name}")
    public List<Book> getBookBySimilarName(@PathVariable String name) {
        return bookRepo.findByTitleContainsIgnoreCase(name);
    }

    @GetMapping(value = "/author/{name}")
    public ArrayList<Book> getBookBySimilarAuthorName(@PathVariable String name) {
        List<Author> authors = authorRepo.findByLnameContainingOrFnameContaining(name, name);
        ArrayList<Book> books = new ArrayList<>();
        for(Author author:authors) {
                for (Book book:author.getBooks()) {
                    if (!books.contains(book)) {
                        books.add(book);
                    }
                }
            }
        return books;
    }
}
package com.lambdaschool.javabookstore.controllers;

import com.lambdaschool.javabookstore.models.Book;
import com.lambdaschool.javabookstore.repositories.BookRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @ApiOperation(value = "Returns a list of all books.", response = List.class)
    @GetMapping(value = "")
    public List<Book> listAllBooks() {
        return bookRepo.findAll();
    }
}
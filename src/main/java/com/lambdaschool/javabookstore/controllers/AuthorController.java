package com.lambdaschool.javabookstore.controllers;

import com.lambdaschool.javabookstore.models.Author;
import com.lambdaschool.javabookstore.repositories.AuthorRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    @Autowired
    AuthorRepository authorRepo;

    @ApiOperation(value = "Returns a list of all authors.", response = List.class)
    @GetMapping(value = "")
    public List<Author> listAllAuthors() {
        return authorRepo.findAll();
    }
}
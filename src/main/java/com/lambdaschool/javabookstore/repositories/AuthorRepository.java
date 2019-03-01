package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByLnameContainingOrFnameContaining(String lname, String fname);
}

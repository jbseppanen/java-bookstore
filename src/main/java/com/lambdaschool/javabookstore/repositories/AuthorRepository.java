package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

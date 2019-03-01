package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainsIgnoreCase(String name);
}

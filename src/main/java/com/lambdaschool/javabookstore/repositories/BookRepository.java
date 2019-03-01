package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

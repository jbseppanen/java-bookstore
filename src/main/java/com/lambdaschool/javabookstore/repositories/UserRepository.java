package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
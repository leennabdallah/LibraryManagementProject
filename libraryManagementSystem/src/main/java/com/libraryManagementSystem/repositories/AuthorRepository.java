package com.libraryManagementSystem.repositories;

import com.libraryManagementSystem.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

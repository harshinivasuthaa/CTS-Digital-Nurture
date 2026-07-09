package com.library.LibraryManagementSpringboot.repository;

import com.library.LibraryManagementSpringboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}


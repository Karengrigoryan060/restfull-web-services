package com.springlesson.rest.webservices.restfullwebservices.repository;

import com.springlesson.rest.webservices.restfullwebservices.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> findByAuthor(String author);
}
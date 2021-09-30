package com.springlesson.rest.webservices.restfullwebservices.controller;

import com.springlesson.rest.webservices.restfullwebservices.dto.BookResponse;
import com.springlesson.rest.webservices.restfullwebservices.dto_service.BookDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDTOService bookDTOService;

    @GetMapping("/books/{id}")
    public BookResponse getBookById(@PathVariable("id") Long id) {
        return bookDTOService.getById(id);
    }

    @GetMapping("/books/author/{author}")
    public List<BookResponse> getAllBooksByAuthor(@PathVariable("author") String author) {
        return bookDTOService.getByAuthor(author);
    }
}

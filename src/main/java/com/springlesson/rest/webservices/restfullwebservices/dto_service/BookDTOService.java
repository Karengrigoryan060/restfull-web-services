package com.springlesson.rest.webservices.restfullwebservices.dto_service;

import com.springlesson.rest.webservices.restfullwebservices.dto.BookRequest;
import com.springlesson.rest.webservices.restfullwebservices.dto.BookResponse;
import com.springlesson.rest.webservices.restfullwebservices.entity.Book;
import com.springlesson.rest.webservices.restfullwebservices.interfaces.DTOService;
import com.springlesson.rest.webservices.restfullwebservices.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookDTOService implements DTOService<BookRequest, BookResponse> {

    @Autowired
    private BookService bookService;

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Book book = bookService.save(bookRequestToBook(bookRequest));
        return bookToBookResponse(book);
    }

    @Override
    public List<BookResponse> getAll() {
        return bookService.getAll().stream().map(BookDTOService::bookToBookResponse).collect(Collectors.toList());
    }

    @Override
    public BookResponse getById(Long id) {
        Book book = bookService.getById(id);
        return bookToBookResponse(book);
    }

    @Override
    public void delete(BookRequest bookRequest) {
        bookService.delete(bookRequestToBook(bookRequest));
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }

    public List<BookResponse> getByAuthor(String author) {
        return bookService.getByAuthor(author).stream().map(BookDTOService::bookToBookResponse).collect(Collectors.toList());
    }

    public static Book bookRequestToBook(BookRequest bookRequest) {
        return new Book(bookRequest.getName(), bookRequest.getAuthor(), bookRequest.getContent(), bookRequest.getUser());
    }

    public static BookResponse bookToBookResponse(Book book) {
        return new BookResponse(book.getId(), book.getAuthor(), book.getName(), book.getContent(), book.getUser());
    }
}
package com.springlesson.rest.webservices.restfullwebservices.service;

import com.springlesson.rest.webservices.restfullwebservices.entity.Book;
import com.springlesson.rest.webservices.restfullwebservices.exceptions.BookNotFoundException;
import com.springlesson.rest.webservices.restfullwebservices.interfaces.IService;
import com.springlesson.rest.webservices.restfullwebservices.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService implements IService<Book> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(String.format("Book with : %s ID doesn't exist", id)));
    }

    @Override
    @Transactional
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getByAuthor(String author) {
        return bookRepository.findByAuthor(author).orElseThrow(()->new BookNotFoundException(String.format("Book with %s author not found",author)));
    }
}
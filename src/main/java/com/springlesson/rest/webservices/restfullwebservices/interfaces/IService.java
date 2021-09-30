package com.springlesson.rest.webservices.restfullwebservices.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService<T> {

    T save(T t);

    List<T> getAll();

    T getById(Long id);

    void delete(T t);

    void deleteById(Long id);
}
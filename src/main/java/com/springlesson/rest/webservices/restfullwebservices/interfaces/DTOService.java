package com.springlesson.rest.webservices.restfullwebservices.interfaces;

import java.util.List;

public interface DTOService<T, N> {

    N save(T t);

    List<N> getAll();

    N getById(Long id);

    void delete(T t);

    void deleteById(Long id);
}
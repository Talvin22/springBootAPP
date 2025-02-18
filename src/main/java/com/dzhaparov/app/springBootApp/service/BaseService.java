package com.dzhaparov.app.springBootApp.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, S> {

    boolean create(S req);

    Optional<T> getById(Long id);

    List<T> fetchAll();

    void delete(Long id);




}
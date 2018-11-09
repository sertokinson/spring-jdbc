package ru.sertok.spring.jdbc.dao.api;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    void save(T model);
    Optional<T> find(Long id);
    void update(T model);
    void delete(Long id);
    List<T> findAll();
}

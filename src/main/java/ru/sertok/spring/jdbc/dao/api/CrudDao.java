package ru.sertok.spring.jdbc.dao.api;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    void save(T model);
    Optional<T> find(Integer id);
    void update(T model);
    void delete(Integer id);
    List<T> findAll();
}

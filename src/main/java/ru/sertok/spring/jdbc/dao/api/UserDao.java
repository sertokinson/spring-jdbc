package ru.sertok.spring.jdbc.dao.api;


import ru.sertok.spring.jdbc.model.User;

public interface UserDao extends CrudDao<User> {
    Boolean isExist(String name, String password);
}

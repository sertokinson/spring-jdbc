package ru.sertok.spring.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.sertok.spring.jdbc.dao.api.UserDao;
import ru.sertok.spring.jdbc.model.User;
import ru.sertok.spring.jdbc.utils.Utils;

import javax.sql.DataSource;

import java.util.List;
import java.util.Optional;

import static ru.sertok.spring.jdbc.utils.Constants.*;
import static ru.sertok.spring.jdbc.utils.Query.*;

@Component
public class UserDaoJdbcTemplate implements UserDao {

    private JdbcTemplate jdbcTemplate;
    private String[] mutableHash = new String[1];

    private RowMapper<User> rowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getInt(ID))
            .name(resultSet.getString(NAME))
            .birthDate(resultSet.getDate(BIRTH_DATE))
            .password(resultSet.getString(PASSWORD)).build();

    @Autowired
    public UserDaoJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User model) {
        jdbcTemplate.update(INSERT,model.getName(),model.getPassword(),model.getBirthDate());
    }

    @Override
    public Optional<User> find(Integer id) {
        List<User> query = jdbcTemplate.query(SELECT_BY_ID, rowMapper, id);
        return Optional.of(query.get(0));
    }

    @Override
    public void update(User model) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SELECT_ALL,rowMapper);
    }

    public Boolean isExist(String name, String password) {
            List<User> listUsers = jdbcTemplate.query(SELECT_BY_NAME,rowMapper,name);
            for (User user : listUsers) {
                if (user.getName().equals(name) && Utils.verifyAndUpdateHash(password, user.getPassword(), hash -> {
                    mutableHash[0] = hash;
                    return true;
                }))
                    return true;
            }
        return false;
    }
}

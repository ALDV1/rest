package com.example.testtask.repository;

import com.example.testtask.Mapper.UserMapper;
import com.example.testtask.exception.NotFoundException;
import com.example.testtask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<User> findOne(Integer id){
        final String sqlQuery = "select * from users where id = ?";
        return jdbcTemplate.query(sqlQuery,new UserMapper(),id)
                .stream()
                .findFirst();
    }

    public List<User> findAllUser(){
        final String sqlQuery = "select * from users";
        return jdbcTemplate.query(sqlQuery, new UserMapper());
    }

    public int delete(Integer user_id){
        final String sqlQuery = "delete from users where id = ?";
        return jdbcTemplate.update(sqlQuery, user_id);
    }
    public int create(User user){
        final String sqlQuery = "insert into users(first_name, email, profile_photo, online, status)" +
                "values (?,?,?,?,?)";
        return jdbcTemplate.update(sqlQuery, user.getId());
    }

    List<User> findByOnlineAndStatusAfter (boolean online, Timestamp status){
        final String sqlQuery = "SELECT * FROM users WHERE online = ? AND status > ?";
        return jdbcTemplate.query(sqlQuery,new UserMapper(), online, status);
    }

    List<User> findByOnline(){
        final String sqlQuery = "select * from users where online = true";
        return jdbcTemplate.query(sqlQuery, new UserMapper());
    }

    List<User> findByStatusAfter (Timestamp status){
        final String sqlQuery = "SELECT * FROM users WHERE status_timestamp > ?";
        return jdbcTemplate.query(sqlQuery, new UserMapper(), status);
    }
}

package com.example.testtask.Mapper;

import com.example.testtask.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setEmail(rs.getString("email"));
        user.setUrl(rs.getString("profile_photo"));
        user.setOnline(rs.getBoolean("online"));
        user.setStatus(rs.getTimestamp("status"));
        return user;
    }
}

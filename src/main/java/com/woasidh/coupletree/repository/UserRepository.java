package com.woasidh.coupletree.repository;

import com.woasidh.coupletree.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getUserList() {
        String sql = "select * from User";
        return this.jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setUserId(resultSet.getString("userId"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            return user;
        });
    }


    public User getUserByUserId(String userId) {
        String sql = "select * from User where userId = ?";
        return this.jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setUserId(resultSet.getString("userId"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            return user;
        }, userId);
    }
}

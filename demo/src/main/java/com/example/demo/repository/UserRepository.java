package com.example.demo.repository;

import com.example.demo.dto.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private RowMapper<UserDto> userRowMapper = (rs, rowNum) ->
            new UserDto(rs.getInt("userId"), rs.getString("userName"), rs.getString("userPassword"), rs.getString("userEmail"), rs.getString("userProfileImgUrl"));
    public List<UserDto> findAll() {
        return jdbcTemplate.query("select * from User", userRowMapper);
    }
}

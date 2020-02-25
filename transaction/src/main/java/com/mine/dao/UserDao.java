package com.mine.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    private String name;
    private Integer age;

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void addUser() {
        String sql = " insert into user (name,age) value(?,?)";
        jdbcTemplate.update(sql, "name", 2);
        System.out.println("添加数据成功！");
    }

    public void addUser(String name,Integer age) {
        String sql = " insert into user value(?,?)";
        jdbcTemplate.update(sql, name, age);
        System.out.println("添加数据成功！");
    }
    public void huoquUser(String name) {
        String sql = " select * from user where name = '" + name + "'";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println("获取数据成功！");
    }
}

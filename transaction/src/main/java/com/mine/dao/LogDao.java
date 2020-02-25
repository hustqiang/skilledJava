package com.mine.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName LogDao
 * @Description 事务从传播测试
 * @Author zhangqiang
 * @Date 2020-02-21 22:43
 * @ModifyDate 2020-02-21 22:43
 * @Version 1.0
 */

@Repository
public class LogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addLog(){
        String sql = "insert into log (log) value(?);";
        jdbcTemplate.update(sql,"test");
        System.out.println("插入日志数据成功");
    }
}

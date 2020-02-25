package com.mine.service;

import com.mine.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LogService
 * @Description TODO
 * @Author zhangqiang
 * @Date 2020-02-21 22:49
 * @ModifyDate 2020-02-21 22:49
 * @Version 1.0
 */
@Service
public class LogService {

    @Autowired
    LogDao logDao;


    public void addLog(){
        logDao.addLog();
        System.out.println("插入日志成功");
    }
}

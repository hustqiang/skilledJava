package com.mine.service;

import com.mine.dao.UserDao;
import com.mine.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    LogService logService;

    @Autowired
    private TransactionManager transactionManager;

    public void add() {
        TransactionStatus transactionStatus = transactionManager.begin();
        try {
            userDao.addUser("zhangsan", 20);
            System.out.println("插入张三成功");
            int i = 1 / 0;
            userDao.addUser("lisi", 10);
            System.out.println("插入李四成功");
            transactionManager.commit(transactionStatus);
        } catch (Exception e) {
            System.out.println("回滚");
            transactionManager.rollback(transactionStatus);
        }
    }

    public void addUser() {
/**
 * 声明式事务，抛出异常才会回滚，如果用了trycatch，那在发生错误之前的数据操作是不会被回滚的
 * 因此，在catch模块中一定要手动回滚
 */
        try {
            userDao.addUser("zhangsan", 20);
            System.out.println("插入张三成功");
            int i = 1 / 0;
            userDao.addUser("lisi", 10);
            System.out.println("插入李四成功");
        } catch (Exception e) {
            System.out.println("出错！回滚数据！");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    public void huoquUser() {
        userDao.huoquUser("zhangsan");

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserTransactionTest() {
        logService.addLog();
        userDao.addUser();
        //int i  = 1/0;
    }

}

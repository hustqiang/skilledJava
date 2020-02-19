package com.mine.service;

import com.mine.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhangqiang
 * @Date 2020-02-19 21:10
 * @ModifyDate 2020-02-19 21:10
 * @Version 1.0
 */
@Service  //等同于<bean id="userService" class="com.mine.service.UserService" ></bean>
public class UserService {

    //set注入的原理是属性必须有set方法，如果不写这个set方法，那么即便xml中传进来userDao，但是这个传入的对象是不能设置到属性中的
    public void setUserDao(UserDao userDao) {
        this.userDao1 = userDao;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

    @Resource
    //@Autowired
    private UserDao userDao1;

    public void add(){
        System.out.println("业务逻辑层");
        userDao1.add();
    }
}

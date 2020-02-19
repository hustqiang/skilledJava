package com.mine.entity;


/**
 * @ClassName UserEntity
 * @Description entity
 * @Author zhangqiang
 * @Date 2020-02-18 22:24
 * @ModifyDate 2020-02-18 22:24
 * @Version 1.0
 */

public class UserEntity {
    public UserEntity(){
        System.out.println("无参构造方法");
    }
    public UserEntity(String name,Integer age){
        System.out.println("有参构造函数");
        this.age=age;
        this.name=name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private  Integer age;


}

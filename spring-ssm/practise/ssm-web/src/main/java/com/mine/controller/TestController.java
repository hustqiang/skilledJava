package com.mine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author zhangqiang
 * @Date 2020-02-27 21:42
 * @ModifyDate 2020-02-27 21:42
 * @Version 1.0
 */

@Controller
public class TestController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}

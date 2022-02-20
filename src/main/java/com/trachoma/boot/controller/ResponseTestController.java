package com.trachoma.boot.controller;

import com.trachoma.boot.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Administrator
 * @create 2022-02-20 0:56
 */
@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/file")
    public FileSystemResource file() {
        return null;
    }

    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson() {
        Person person = new Person();
        person.setUserName("zhangsan");
        person.setAge(18);
        person.setBirth(new Date());
        return person;
    }
}

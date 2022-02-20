package com.trachoma.boot.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 * @create 2022-02-19 23:41
 */
@Data
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}

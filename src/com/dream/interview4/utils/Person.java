package com.dream.interview4.utils;


import lombok.*;

/**
 * @Author : huzejun
 * @Date: 2024/7/21-23:11
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    //温馨提醒，
    // 本类没有覆写hashcode和equals方法
    private Integer id;
    private String personName;

    public Person(String personName)
    {
        this.personName = personName;
    }
}

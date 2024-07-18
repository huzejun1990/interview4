package com.dream.interview4.javase;

/**
 * @Author : huzejun
 * @Date: 2024/7/18-19:16
 */
public class Integer_BugDemo {

    public static void main(String[] args) {

        Integer a = Integer.valueOf(600);   //
        Integer b = Integer.valueOf(600);
        int c  = 600;
        System.out.println(a == b);     // false
        System.out.println(a.equals(b));    //true
        System.out.println(a == c);     //true

        System.out.println("=============");

        Integer x = Integer.valueOf(99);
        Integer y = Integer.valueOf(99);
        System.out.println(x == y);
        System.out.println(x.equals(y));

    }
}

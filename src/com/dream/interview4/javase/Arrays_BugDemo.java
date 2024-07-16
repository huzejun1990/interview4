package com.dream.interview4.javase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : huzejun
 * @Date: 2024/7/16-20:38
 */
public class Arrays_BugDemo {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        list.add(6);

        list.forEach(System.out::println);
    }
}

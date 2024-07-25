package com.dream.interview4.idea;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : huzejun
 * @Date: 2024/7/25-22:49
 */
public class ArrayListResizeDebug {

    public static void main(String[] args) {
        //jdk17默认初始值是10，第二次扩容是多少？
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 17; i++) {
            list.add(i);
        }
        list.forEach(r -> System.out.print(r + " "));
    }
}

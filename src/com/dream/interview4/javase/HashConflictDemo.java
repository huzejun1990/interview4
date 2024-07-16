package com.dream.interview4.javase;

import java.util.HashSet;

/**
 * @Author : huzejun
 * @Date: 2024/7/16-23:51
 */
public class HashConflictDemo {
    static class Book
    {
        int id;
    }

    public static void main(String[] args) {
        //请你写一个hashcode冲突的案例 v2
        //当我们正常的new对象的时候，new多少次对象，会有可能出现hash冲突
        HashSet<Integer> hashSet = new HashSet<>();
        
        for (int i = 1; i <= 15 * 10000; i++) {
//            int bookHashCode = new Book().hashCode();
            int bookHashCode = new Object().hashCode();
            if (!hashSet.contains(bookHashCode)) {
                hashSet.add(bookHashCode);
            }else {
                System.out.println("发生了hash冲突，在第："+i+"次，值是："+bookHashCode);
            }
        }
        System.out.println(hashSet.size());

    }

    private static void m1() {
        //请你写一个hashcode冲突的案例
        System.out.println("AA".hashCode());
        System.out.println("BB".hashCode());
        System.out.println();

        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println();

        System.out.println("柳柴".hashCode());
        System.out.println("柴柕".hashCode());    //柕
    }
}

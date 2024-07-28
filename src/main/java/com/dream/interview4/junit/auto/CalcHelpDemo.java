package com.dream.interview4.junit.auto;

/**
 * @Author : huzejun
 * @Date: 2024/7/29-2:31
 */
public class CalcHelpDemo {

    public int mul(int x, int y) {
        return x * y;
    }

    @AtguiguTest
    public int div(int x, int y) {
        return x / y;
    }

    @AtguiguTest
    public void thank(int x,int y){
        System.out.println("thinks,help me test bug");
    }
}

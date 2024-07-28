package com.dream.interview4.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : huzejun
 * @Date: 2024/7/25-23:25
 */
class CalcDemoTest {

    @Test
    void add() {
        CalcDemo calcDemo = new CalcDemo();
        System.out.println(calcDemo.add(2, 2));  // error,看到绿条不一定正确
        int retValue = calcDemo.add(2,2);
        assertEquals(4,retValue);

        //看到绿条+使用了assert断言也不一定正确，为什么单元测试的多样性和覆盖率如此重要
        retValue = calcDemo.add(2,7);
        assertEquals(9,retValue);

    }

    @Test
    void sub() {
    }
}
package com.dream.interview4.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author : huzejun
 * @Date: 2024/7/28-23:11
 */
 class CalcDemoTestV2 {

    CalcDemo calcDemo = null;

    static StringBuffer stringBuffer = null;

    @BeforeAll
    static void m1() {
        stringBuffer = new StringBuffer("abc");
        System.out.println("================: "+stringBuffer.length());
    }

    @BeforeAll
    static void m2() {
        System.out.println("================: "+stringBuffer.append(" ,end").toString());
    }

    @BeforeEach
    void setUp() {
        System.out.println("---------come in BeforeEach");
        calcDemo = new CalcDemo();
    }

    @AfterEach
    void tearDown() {
        System.out.println("-----------come in AfterFach");
        calcDemo = null;
    }

    @Test
    void add() {
        Assertions.assertEquals(5,calcDemo.add(1,4));
        assertEquals(5,calcDemo.add(2,3));
    }

    @Test
    void sub() {
        assertEquals(5,calcDemo.sub(10,5));
    }
}

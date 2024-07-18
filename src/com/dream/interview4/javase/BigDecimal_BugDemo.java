package com.dream.interview4.javase;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author : huzejun
 * @Date: 2024/7/18-21:58
 */
public class BigDecimal_BugDemo {
    public static void main(String[] args) {
        //double类型精度丢失
//        doubleDemo();
//        m1();
//        m2();
//        m3();
        m4();
    }

    /**
     * 科学计数法相关
     */
    private static void m4() {
        BigDecimal amount1 = BigDecimal.valueOf(1234567890123456789.31212321231);
        System.out.println(amount1);                //科学计数法 1.23456789012345677E+18
        System.out.println(amount1.toString());      //科学计数法 1.23456789012345677E+18
        System.out.println(amount1.toPlainString());     //科学计数法 1234567890123456770

        System.out.println();
        BigDecimal amount2 = new BigDecimal("1234567890123456789.3141592631415926");
        System.out.println(amount2);
        System.out.println(amount2.toString());
        System.out.println(amount2.toPlainString());
    }

    /**
     * 除法商的结果，需要指定精度
     * BigDecimal 的 8种 RoundingMode(舍入模式)
     *
     * ROUND_HALF_UP 也就是我们常说的我们的“四舍五入”
     * 向“最接近”的数字舍入和，如果与相邻的距离相等，则为向上舍入的舍入模式
     * 如果舍弃部分 >= 0.5,则舍入行为与 ROUND_UP 相同，否则舍入行为 ROUND_DOWN相同。
     * 这种模式也就是我们常说的“四舍五入”
     *
     * ROUND_HALF_DOWN
     *
     * 向“最接近”的数字舍入，如果与两个相邻数字的距离相等，则为向下舍入的舍入模式。
     * 如果舍弃部分 > 0.5，则舍入行为与 ROUND_UP 相同; 否则舍入行为与 ROUND_DOWN相同。
     * 这种械也就是我们常说的“五舍六入”
     */
    private static void m3() {
        BigDecimal amount1 = new BigDecimal("2.0");
        BigDecimal amount2 = new BigDecimal("3.0");
//        System.out.println(amount1.divide(amount2));    // Non-terminating decimal expansion; no exact representable decimal result
        //我们应该如何处理
        System.out.println(amount1.divide(amount2,2, RoundingMode.HALF_UP));    //这种模式就是我们说的"四舍五入"
    }

    private static void m2() {
        BigDecimal amount1 = new BigDecimal("0.9");
        BigDecimal amount2 = new BigDecimal("0.90");
        //给大家看一下equals源码，它有个精度范围比较导致出错
        System.out.println("equals比较结果： "+amount1.equals(amount2));
        System.out.println("compareTo比较结构： "+amount1.compareTo(amount2));
    }

    private static void m1() {
        //看看构造方法源码第934行
        BigDecimal amount1 = new BigDecimal(0.03);
        BigDecimal amount2 = new BigDecimal(0.02);
        //12,[强制]禁止使用构造方法BigDecimal(double) 的方式把double转化为BigDecimal对象，非要 转
        System.out.println("amount1:"+amount1);
        System.out.println("amount2:"+amount2);
        //应该等于0.01
        System.out.println("amount1 - amount2等于： "+amount1.subtract(amount2));
        System.out.println();
        //优先推荐入参为string的构造方法
        BigDecimal amount3 = new BigDecimal("0.03");
        BigDecimal amount4 = new BigDecimal("0.02");
        //应该等于0.01
        System.out.println(amount3.subtract(amount4));
        System.out.println();

        //使用BigDecimal的valueOf方法，给大家看一下valueOf源码
        BigDecimal amount5 = BigDecimal.valueOf(0.03);
        BigDecimal amount6 = BigDecimal.valueOf(0.02);
        //应该等于0.01
        System.out.println(amount5.subtract(amount6));
    }

    /**
     * why
     * double类型的两个参数相减会转换成二进制。
     * 因为double有效位数为16位这就会出现存储小数位数不够的情况，这种情况下就会出现误差
     */
    private static void doubleDemo(){
        double amount1 = 0.03;
        double amount2 = 0.02;
        //执行结果会是多少
        System.out.println(amount1 - amount2);  // 0.009999999999999998
    }
}

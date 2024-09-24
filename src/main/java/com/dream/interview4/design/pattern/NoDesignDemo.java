package com.dream.interview4.design.pattern;

/**
 * @Auther: huzejun
 * @Date: 2024/9/24 21:06
 */
public class NoDesignDemo {
    public void more_ifElse(String parameter) {
        /**
         * 思考，两个干掉
         * 1 if...else if 判断分支本身里面的业务逻辑，比如 System.out.println("我是百事可乐")
         * 2 if... else if 判断分支本身
         */
        if ("Pepsi".equals(parameter)) {
            System.out.println("我是百事可乐-初始无设计");
            System.out.println("我是百事可乐-初始无设计");
            System.out.println("我是百事可乐-初始无设计");
            System.out.println("我是百事可乐-初始无设计");
            System.out.println("我是百事可乐-初始无设计");
            System.out.println("我是百事可乐-初始无设计");
            System.out.println("我是百事可乐-初始无设计");
            System.out.println("我是百事可乐-初始无设计");
            System.out.println("我是百事可乐-初始无设计");
            System.out.println("我是百事可乐-初始无设计");
        } else if ("Coca".equalsIgnoreCase(parameter)) {
            System.out.println("我是可口可乐-初始无设计");
            if ("618".equals(parameter)) {
                //需要配合618积分平台大促活动，涉及复杂业务
            }
            if ("111".equals(parameter)) {
                //需要配合双11优惠券平台大促活动，涉及复杂业务
                //1 MQ两步消息给其它下游系统
                //2 xxl-job做好定时任务扫描，当晚下单下单顾客，没1分钟统计一次送给QTL系统
                //3...
            }
        } else if ("Wahaha".equalsIgnoreCase(parameter)) {
            System.out.println("我是娃哈哈可乐-初始无设计");
        }

    }

    public static void main(String[] args) {
        new NoDesignDemo().more_ifElse("wahaha");
    }
}

/*
interface MyFoo {   //抽象类
    public void m1();
    public void m2();

    public void m3();

}

class A implements MyFoo {

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }
}
*/

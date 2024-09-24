package com.dream.interview4;

import com.dream.interview4.design.pattern.v2.Factory;
import com.dream.interview4.design.pattern.v2.HandlerStrategyFactory;
import com.dream.interview4.design.pattern.v3.AbstractColaHandler;
import com.dream.interview4.design.pattern.v3.FactoryV3;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Auther: huzejun
 * @Date: 2024/9/25 00:06
 */
@SpringBootTest
public class DesignPatternTest {

    /**
     * 策略+工厂 V2
     */
    @Test
    public void methodV2() {
        String parameter = "Coca";

        HandlerStrategyFactory invokeStrategy = Factory.getInvokeStrategy(parameter);

        invokeStrategy.getCoca(parameter);

    }

    /**
     * 策略+工厂+模板方法模式V3
     */
    @Test
    public void methodV3() {
        String parameter = "Coca";
        AbstractColaHandler handler = FactoryV3.getInvokeStrategy(parameter);

        handler.getCoca(parameter);

        System.out.println(handler.cocaMethod("可口可乐"));

    }
}

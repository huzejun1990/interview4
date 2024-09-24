package com.dream.interview4.design.pattern.v2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: huzejun
 * @Date: 2024/9/24 23:19
 */
public class Factory {

    private static Map<String,HandlerStrategyFactory> strategyMap = new ConcurrentHashMap<>();

    public static HandlerStrategyFactory getInvokeStrategy(String str) {
        return strategyMap.get(str);
    }

    public static void register(String str,HandlerStrategyFactory handler) {
        System.out.println("str: "+str+"\t handler: "+handler);
        if (null == str || null == handler) {
            return;
        }
        strategyMap.put(str,handler);
    }

}

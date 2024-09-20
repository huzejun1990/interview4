package com.dream.interview4.controller;

import cn.hutool.core.util.IdUtil;
import com.dream.interview4.annotations.RedisLimitAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : huzejun
 * @Date: 2024/9/17-21:22
 */

@Slf4j
@RestController
public class RedisLimitController {

    @GetMapping("/redis/limit/test")
    @RedisLimitAnnotation(key = "redisLimit",permitsPerSecond = 3,expire = 10,msg = "当前访问人数较多，自定义提示")
    public String redisLimit()
    {
        return "正常业务返回，订单流水："+ IdUtil.fastUUID();
    }

    @GetMapping("/redis/limit/m1")
    @RedisLimitAnnotation(key = "redisLimitM1",permitsPerSecond = 2,expire = 1,msg = "当前访问人数较多，自定义提示")
    public void m1()
    {

    }

}

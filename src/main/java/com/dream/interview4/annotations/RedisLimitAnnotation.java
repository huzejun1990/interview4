package com.dream.interview4.annotations;

import java.lang.annotation.*;

/**
 * @Author : huzejun
 * @Date: 2024/9/17-21:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface RedisLimitAnnotation {

    /**
     * 资源的key,唯一
     * 作用：不同的接口，不同的流量控制
     * @return
     */
    String key() default "";

    /**
     * 最多的访问限制次数
     * @return
     */
    long permitsPerSecond() default 3;

    /**
     * 过期时间（计算窗口时间），单位秒默认30
     * @return
     */
    long expire() default 30;

    String msg() default "default message:系统繁忙or你点击得太快，请稍后再试,谢谢";
}

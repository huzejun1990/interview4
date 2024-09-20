package com.dream.interview4.exception;

/**
 * @Author : huzejun
 * @Date: 2024/9/18-2:46
 */

/**
 * Redis限流自定义异常
 */
public class RedisLimitException extends RuntimeException {

    public RedisLimitException(String msg) {
        super(msg);
    }

}

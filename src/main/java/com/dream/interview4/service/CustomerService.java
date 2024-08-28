package com.dream.interview4.service;

import com.dream.interview4.entities.CustomerMixInfo;

/**
 * @Author : huzejun
 * @Date: 2024/8/29-4:10
 */
public interface CustomerService {
    public CustomerMixInfo findCustomer();

    public CustomerMixInfo findCustomerByCompletableFuture();

}

package com.dream.interview4.controller;

import com.dream.interview4.entities.CustomerMixInfo;
import com.dream.interview4.service.CustomerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : huzejun
 * @Date: 2024/8/29-4:07
 */
@RestController
@Slf4j
public class CustomerController {


    @Resource
    private CustomerService customerService;

    @GetMapping(value = "/customer/findv1")
    public CustomerMixInfo findCustomer()
    {
        return customerService.findCustomer();
    }

    @GetMapping(value = "/customer/findv2")
    public CustomerMixInfo findCustomerByCompletableFuture()
    {
        return customerService.findCustomerByCompletableFuture();
    }


}

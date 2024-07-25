package com.dream.interview4.controller;

import com.dream.interview4.entities.User;
import com.dream.interview4.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : huzejun
 * @Date: 2024/7/23-19:05
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/user/add")
    public int addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }


}

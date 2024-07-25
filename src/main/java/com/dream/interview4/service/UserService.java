package com.dream.interview4.service;

import com.dream.interview4.entities.User;

/**
 * @Author : huzejun
 * @Date: 2024/7/23-19:25
 */
public interface UserService {
    public int addUser(User user);

    public User getUserById(Integer id);
}

package com.dream.interview4.service.impl;

import com.dream.interview4.entities.User;
import com.dream.interview4.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author : huzejun
 * @Date: 2024/7/29-4:01
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }
}

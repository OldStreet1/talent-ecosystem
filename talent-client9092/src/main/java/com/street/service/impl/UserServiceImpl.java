package com.street.service.impl;

import com.street.bean.User;
import com.street.mapper.UserMapper;
import com.street.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/24 20:13
 * @desc:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryall() {
        return userMapper.queryall();
    }

}

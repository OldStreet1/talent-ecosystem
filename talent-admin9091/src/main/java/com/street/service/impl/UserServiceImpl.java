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
 * @date: 2021/7/23 22:46
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

    @Override
    public List<User> queryUser(String opendid) {
        return userMapper.queryUser(opendid);
    }

    @Override
    public List<User> queryphoneUser(String phone) {
        return userMapper.queryphoneUser(phone);
    }

    @Override
    public int updeteopenid(User user) {
        return userMapper.updeteopenid(user);
    }

    @Override
    public int updetepwd(User user) {
        return userMapper.updetepwd(user);
    }
}

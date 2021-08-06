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
    public List<User> yhqzchaxun() {
        return null;
    }

    @Override
    public List<User> yhqzcharu() {
        return null;
    }

    @Override
    public List<User> yhqzxiugai() {
        return null;
    }

    @Override
    public List<User> yhqzshanchu() {
        return null;
    }

    @Override
    public List<University> gxyhcharu() {
        return null;
    }

    @Override
    public List<University> gxyhshanchu() {
        return null;
    }

    @Override
    public List<University> gxyhxiugai() {
        return null;
    }

    @Override
    public List<University> gxyhchaxun() {
        return null;
    }

    @Override
    public List<Recruit> zpxxcharu() {
        return null;
    }

    @Override
    public List<Recruit> zpxxshanchu() {
        return null;
    }

    @Override
    public List<Recruit> zpxxxiugai() {
        return null;
    }

    @Override
    public List<Recruit> zpxxchaxun() {
        return null;
    }

    @Override
    public List<Resume> jlcharu() {
        return null;
    }

    @Override
    public List<Resume> jlshanchu() {
        return null;
    }

    @Override
    public List<Resume> jlxiugai() {
        return null;
    }

    @Override
    public List<Resume> jlchaxun() {
        return null;
    }

    @Override
    public List<Chat> ltjlcharu() {
        return null;
    }

    @Override
    public List<Chat> ltjlshanchu() {
        return null;
    }

    @Override
    public List<Chat> ltjlxiugai() {
        return null;
    }

    @Override
    public List<Chat> ltjlchaxun() {
        return null;
    }


}

package com.street.service;

import com.street.bean.User;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/23 22:46
 * @desc:
 */
public interface UserService {
    public List<User> queryall();
    //通过openid进行查找用户
    List<User> queryUser(String opendid);
    //通过手机号查找用户是否存在
    List<User> queryphoneUser(String phone);
    //修改openid
    int updeteopenid(User user);
}

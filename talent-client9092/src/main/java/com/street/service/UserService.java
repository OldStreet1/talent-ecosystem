package com.street.service;

import com.street.bean.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/24 20:13
 * @desc:
 */
public interface UserService {
    public List<User> queryall();

}

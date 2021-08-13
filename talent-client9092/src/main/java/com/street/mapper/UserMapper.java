package com.street.mapper;

import com.street.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/24 20:12
 * @desc:
 */
@Repository
public interface UserMapper {
    List<User> queryall();



}

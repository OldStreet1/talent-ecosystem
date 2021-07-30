package com.street.mapper;

import com.street.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/23 22:45
 * @desc:
 */

@Repository
public interface UserMapper {
    //查找所有的用户
    List<User> queryall();
    //通过openid进行查找用户
    List<User> queryUser(String opendid);
}

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
    //通过手机号查找用户是否存在
    List<User> queryphoneUser(String phone);
    //修改openid
    int updeteopenid(User user);

//    用户求职表相关
    List<User> yhqzchaxun();
    List<User> yhqzcharu();
    List<User> yhqzxiugai();
    List<User> yhqzshanchu();

//    招聘信息表
    List<Recruit> zpxxcharu();
    List<Recruit> zpxxshanchu();
    List<Recruit> zpxxxiugai();
    List<Recruit> zpxxchaxun();

//        简历表
    List<Resume> jlcharu();
    List<Resume> jlshanchu();
    List<Resume> jlxiugai();
    List<Resume> jlchaxun();

//    聊天记录表
    List<Chat> ltjlcharu();
    List<Chat> ltjlshanchu();
    List<Chat> ltjlxiugai();
    List<Chat> ltjlchaxun();
}

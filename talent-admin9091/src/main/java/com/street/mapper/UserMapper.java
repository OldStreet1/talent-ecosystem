package com.street.mapper;

import com.street.bean.*;
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
    List<User> queryall();
//    岗位相关
    List<Post> gwchaxun();
    List<Post> gwcharu();
    List<Post> gwxiugai();
    List<Post> gwshanchu();

//    用户求职表相关
    List<User> yhqzchaxun();
    List<User> yhqzcharu();
    List<User> yhqzxiugai();
    List<User> yhqzshanchu();

//    企业用户表
    List<Enterprise> qyyhcharu();
    List<Enterprise> qyyhshanchu();
    List<Enterprise> qyyhxiugai();
    List<Enterprise> qyyhchaxun();

//    管理用户表
    List<Admin> gmusercharu();
    List<Admin> gmusershanchu();
    List<Admin> gmuserxiugai();
    List<Admin> gmuserchaxun();

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

}

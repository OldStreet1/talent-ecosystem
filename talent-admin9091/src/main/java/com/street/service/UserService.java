package com.street.service;
import com.street.bean.*;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/23 22:46
 * @desc:
 */
public interface UserService {
    public List<User> queryall();
//    Post 岗位相关
    public List<Post> gwchaxun();
    public List<Post> gwcharu();
    public List<Post> gwxiugai();
    public List<Post> gwshanchu();
//        User 求职用户表
    public List<User> yhqzchaxun();
    public List<User> yhqzcharu();
    public List<User> yhqzxiugai();
    public List<User> yhqzshanchu();
//    企业用户表 enterprise
    public List<Enterprise> qyyhcharu();
    public List<Enterprise> qyyhshanchu();
    public List<Enterprise> qyyhxiugai();
    public List<Enterprise> qyyhchaxun();
//    高校用户表
    public List<University> gxyhcharu();
    public List<University> gxyhshanchu();
    public List<University> gxyhxiugai();
    public List<University> gxyhchaxun();
//    管理用户表
    public List<Admin> gmusercharu();
    public List<Admin> gmusershanchu();
    public List<Admin> gmuserxiugai();
    public List<Admin> gmuserchaxun();
}

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
    List<User> queryall();
//        User 求职用户表
List<User> yhqzchaxun();
    List<User> yhqzcharu();
    List<User> yhqzxiugai();
    List<User> yhqzshanchu();
//    高校用户表
List<University> gxyhcharu();
    List<University> gxyhshanchu();
    List<University> gxyhxiugai();
    List<University> gxyhchaxun();
//    招聘信息表
List<Recruit> zpxxcharu();
    List<Recruit> zpxxshanchu();
    List<Recruit> zpxxxiugai();
    List<Recruit> zpxxchaxun();
//    简历表
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

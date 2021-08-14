package com.street.service;

import com.street.bean.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> queryall();
    List<Admin> allchaxun();
    //    管理用户表
    List<Admin> gmusercharu();
    List<Admin> gmusershanchu();
    List<Admin> gmuserxiugai();
    List<Admin> gmuserchaxun();
import com.street.bean.Menu;

import java.util.List;


public interface AdminService {
    //后台注册
    int AdminAdd(Admin admin);
    //后台管理登录
    Admin AdminLogin(Admin admin);
   //查询账号是否存在
    List<Admin> UserSelect(String admin_account);
    //菜单栏查询
    List<Menu> MenuSelect(Menu menu);
}

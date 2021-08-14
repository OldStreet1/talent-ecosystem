package com.street.service;

import com.street.bean.Admin;
import com.street.bean.Menu;
import com.street.dto.AdminDto;

import java.util.List;


public interface AdminService {
    //后台注册
    int AdminAdd(Admin admin);
    //后台管理登录
    AdminDto AdminLogin(Admin admin);
   //查询账号是否存在
    List<Admin> UserSelect(String admin_account);
    //菜单栏查询
    List<Menu> MenuSelect(Menu menu);
}

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
    //查询用户所有信息
    List<AdminDto> AdminSelect(Admin admin);
    //删除用户信息
    int AdminDelete(String admin_id);
    //启用用户状态
    int AdminEnable(String admin_id);
    //禁用用户状态
    int AdminDisable(String admin_id);
}

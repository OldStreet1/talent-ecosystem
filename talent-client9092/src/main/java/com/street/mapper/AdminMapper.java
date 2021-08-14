package com.street.mapper;

import com.street.bean.Admin;
import com.street.bean.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    //后台管理登录
    List<Admin> AdminLogin(Admin admin);

    //后台注册
    int AdminAdd(Admin admin);

    //查询账号是否存在
    List<Admin> UserSelect(String admin_account);

    //菜单栏查询
    List<Menu> MenuSelect(Menu menu);

}

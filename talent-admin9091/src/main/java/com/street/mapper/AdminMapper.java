package com.street.mapper;

import com.street.bean.Admin;
import com.street.bean.Menu;
import com.street.dto.AdminDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    //后台管理登录
    AdminDto AdminLogin(Admin admin);

    //后台注册
    int AdminAdd(Admin admin);

    //查询用户所有信息
    List<AdminDto> AdminSelect(Admin admin);

    //删除用户信息
    int AdminDelete(String admin_id);

    //启用用户状态
    int AdminEnable(String admin_id);

    //禁用用户状态
    int AdminDisable(String admin_id);

    //查询账号是否存在
    List<Admin> UserSelect(String admin_account);

    //菜单栏查询
    List<Menu> MenuSelect(Menu menu);

}

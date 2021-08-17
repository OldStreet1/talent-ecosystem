package com.street.service.impl;

import com.street.bean.Admin;
import com.street.bean.Menu;
import com.street.dto.AdminDto;
import com.street.mapper.AdminMapper;
import com.street.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override //后台登录方法
    public AdminDto AdminLogin(Admin admin) {
        return adminMapper.AdminLogin(admin);
    }

    @Override //查询用户所有信息
    public List<AdminDto> AdminSelect(Admin admin) {
        return adminMapper.AdminSelect(admin);
    }
    @Override //删除用户信息
    public int AdminDelete(String admin_id) {
        return adminMapper.AdminDelete(admin_id);
    }

    @Override //启用用户状态
    public int AdminEnable(String admin_id) {
        return adminMapper.AdminEnable(admin_id);
    }

    @Override //禁用用户状态
    public int AdminDisable(String admin_id) {
        return adminMapper.AdminDisable(admin_id);
    }

    @Override
    public int AdminAdd(Admin admin) {
        return adminMapper.AdminAdd(admin);
    }
    @Override
    public List<Admin> UserSelect(String admin_account) {
        return adminMapper.UserSelect(admin_account);
    }
    @Override
    public List<Menu> MenuSelect(Menu menu) {
        return adminMapper.MenuSelect(menu);
    }




}

package com.street.service.impl;

import com.street.bean.Admin;
import com.street.bean.Menu;
import com.street.mapper.AdminMapper;
import com.street.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> queryall() {
        return adminMapper.queryall();
    }

    @Override
    public List<Admin> allchaxun() {
        return adminMapper.allchaxun();
    }

    @Override
    public List<Admin> gmusercharu() {
        return null;
    }

    @Override
    public List<Admin> gmusershanchu() {
        return null;
    }

    @Override
    public List<Admin> gmuserxiugai() {
        return null;
    }

    @Override
    public List<Admin> gmuserchaxun() {
        return null;
    }

    @Override //后台登录方法
    public List<Admin> AdminLogin(Admin admin) {
        return adminMapper.AdminLogin(admin);
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

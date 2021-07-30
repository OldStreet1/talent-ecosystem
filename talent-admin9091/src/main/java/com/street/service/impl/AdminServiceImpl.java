package com.street.service.impl;

import com.street.bean.Admin;
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
}

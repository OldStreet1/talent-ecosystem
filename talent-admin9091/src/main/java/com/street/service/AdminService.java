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
}

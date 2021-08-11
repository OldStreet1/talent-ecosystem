package com.street.mapper;

import com.street.bean.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    List<Admin> queryall();
    List<Admin> allchaxun();
    //    管理用户表
    List<Admin> gmusercharu();
    List<Admin> gmusershanchu();
    List<Admin> gmuserxiugai();
    List<Admin> gmuserchaxun();
}

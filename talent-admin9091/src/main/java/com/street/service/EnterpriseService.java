package com.street.service;

import com.street.bean.Enterprise;

import java.util.List;

public interface EnterpriseService {
    List<Enterprise> epallchaxun();
    //    企业用户表 enterprise
    List<Enterprise> qyyhcharu();
    int qyyhshanchu(Enterprise enterprise);
    List<Enterprise> qyyhxiugai();
    List<Enterprise> qyyhchaxun();
}

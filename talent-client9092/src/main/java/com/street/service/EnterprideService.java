package com.street.service;

import com.street.bean.Enterprise;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/27 09:09
 * @desc:
 */
public interface EnterprideService {
    //企业注册
    int addEnterpride(Enterprise enterprise);
    //查询企业是否存在
    List<Enterprise> queryEnterpride(String enterprise_acc);
    //企业登陆
    List<Enterprise> enterprideLogin(Enterprise enterprise);
    //查询企业坐标
    String queryEnterpriseCoordinate(String enterprise_name);
}

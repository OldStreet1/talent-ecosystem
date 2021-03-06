package com.street.mapper;

import com.street.bean.Enterprise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/27 09:08
 * @desc:
 */
@Repository
public interface EnterprideMapper {
    //企业注册
    int addEnterpride(Enterprise enterprise);
    //查询企业是否存在
    List<Enterprise> queryEnterpride(String enterprise_acc);
    //企业登陆
    List<Enterprise> enterprideLogin(Enterprise enterprise);
    // 热门企业查询
    List<Enterprise> HotEnterprise();
    //查询企业坐标
    String queryEnterpriseCoordinate(String enterprise_name);
    //企业信息
    List<Enterprise> queryEnterprideData(String enterprise_acc);
    //充钱
    int increaseEnterprideBalance(@Param("enterprise_account_balance") String enterprise_account_balance,
                                  @Param("enterprise_acc")String enterprise_acc);
    //企业信息
    List<Enterprise> queryEnterprideIntro(String enterprise_name);
}

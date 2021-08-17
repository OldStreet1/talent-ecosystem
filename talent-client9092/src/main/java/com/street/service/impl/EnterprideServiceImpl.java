package com.street.service.impl;

import com.street.bean.Enterprise;
import com.street.mapper.EnterprideMapper;
import com.street.service.EnterprideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/27 09:09
 * @desc:
 */
@Service
public class EnterprideServiceImpl implements EnterprideService {
    @Autowired
    private EnterprideMapper enterprideMapper;

    @Override
    public int addEnterpride(Enterprise enterprise) {
        return enterprideMapper.addEnterpride(enterprise);
    }

    @Override
    public List<Enterprise> queryEnterpride(String enterprise_acc) {
        return enterprideMapper.queryEnterpride(enterprise_acc);
    }

    @Override
    public List<Enterprise> enterprideLogin(Enterprise enterprise) {
        return enterprideMapper.enterprideLogin(enterprise);
    }

    @Override
    public List<Enterprise> HotEnterprise() {
        return enterprideMapper.HotEnterprise();
    }

    @Override
    public List<Enterprise> AllEnterprise() {
        return enterprideMapper.AllEnterprise();
    }

    @Override
    public String queryEnterpriseCoordinate(String enterprise_name) {
        return enterprideMapper.queryEnterpriseCoordinate(enterprise_name);
    }

    @Override
    public List<Enterprise> queryEnterprideData(String enterprise_acc) {
        return enterprideMapper.queryEnterprideData(enterprise_acc);
    }

    @Override
    public int increaseEnterprideBalance(String enterprise_account_balance, String enterprise_acc) {
        return enterprideMapper.increaseEnterprideBalance(enterprise_account_balance,enterprise_acc);
    }

    @Override
    public List<Enterprise> queryEnterprideIntro(String enterprise_name) {
        return enterprideMapper.queryEnterprideIntro(enterprise_name);
    }

    @Override
    public int ChangePwd(Enterprise enterprise) {
        int i = enterprideMapper.ChangePwd(enterprise);
        return i;
    }
}

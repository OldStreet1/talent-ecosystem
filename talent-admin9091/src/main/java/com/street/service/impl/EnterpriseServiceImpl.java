package com.street.service.impl;

import com.street.bean.Enterprise;
import com.street.mapper.EnterpriseMapper;
import com.street.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//标签
public class EnterpriseServiceImpl implements EnterpriseService {
//    注入
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public List<Enterprise> epallchaxun() {
        return enterpriseMapper.epallchaxun();
    }

    @Override
    public List<Enterprise> qyyhcharu() {
        return null;
    }

    @Override
    public int qyyhshanchu(Enterprise enterprise) {
        return enterpriseMapper.qyyhshanchu(enterprise);
    }

    @Override
    public List<Enterprise> qyyhxiugai() {
        return null;
    }

    @Override
    public List<Enterprise> qyyhchaxun() {
        return null;
    }


}

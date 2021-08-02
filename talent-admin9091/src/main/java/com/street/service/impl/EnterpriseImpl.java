package com.street.service.impl;

import com.street.bean.Enterprise;
import com.street.mapper.EnterpriseMapper;
import com.street.service.EnterpriseService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//标签
public class EnterpriseImpl implements EnterpriseService {
//    注入
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public List<Enterprise> epallchaxun() {
        return enterpriseMapper.epallchaxun();
    }
}

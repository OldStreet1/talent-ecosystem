package com.street.service.impl;

import com.street.bean.Enterprise;
import com.street.mapper.EnterprideMapper;
import com.street.service.EnterprideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

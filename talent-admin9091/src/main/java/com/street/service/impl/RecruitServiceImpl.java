package com.street.service.impl;

import com.street.mapper.RecruitMapper;
import com.street.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/31 22:47
 * @desc:
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    public RecruitMapper recruitMapper;

    @Override
    public List<RuntimeException> queryRecruit(String info) {
        return recruitMapper.queryRecruit(info);
    }
}

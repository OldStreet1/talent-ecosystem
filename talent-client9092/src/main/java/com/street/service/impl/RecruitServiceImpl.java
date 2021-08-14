package com.street.service.impl;

import com.street.bean.Recruit;
import com.street.mapper.RecruitMapper;
import com.street.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitMapper recruitMapper;


    @Override
    public List<Recruit> HotRecruit() {
        List<Recruit> recruits = recruitMapper.HotRecruit();
        return recruits;
    }

    @Override
    public List<Recruit> QueryRecruit(Recruit recruit) {
        List<Recruit> recruits = recruitMapper.QueryRecruit(recruit);
        return recruits;
    }
}

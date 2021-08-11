package com.street.service.impl;

import com.street.bean.University;
import com.street.mapper.UniversityMapper;
import com.street.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityMapper universityMapper;

    @Override
    public List<University> xyallchaxun() {
        return universityMapper.xyallchaxun();
    }

    @Override
    public List<University> gxyhcharu() {
        return null;
    }

    @Override
    public List<University> gxyhshanchu() {
        return null;
    }

    @Override
    public List<University> gxyhxiugai() {
        return null;
    }

    @Override
    public List<University> gxyhchaxun() {
        return null;
    }
}

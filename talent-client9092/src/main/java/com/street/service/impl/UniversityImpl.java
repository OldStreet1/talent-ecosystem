package com.street.service.impl;

import com.street.bean.University;
import com.street.mapper.UniversityMapper;
import com.street.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: xiaozheng
 * @date: 2021/7/26 15:14
 * @desc:
 */
@Service
public class UniversityImpl implements UniversityService {
    @Autowired
    private UniversityMapper universityMapper;
    @Override
    public int checkReg(University university) {
        int i=universityMapper.checkReg(university);
        return i;
    }
}

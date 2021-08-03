package com.street.service.impl;

import com.street.bean.University;
import com.street.bean.User;
import com.street.mapper.UniversityMapper;
import com.street.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
//    注册
    @Override
    public int checkReg(University university) {
        int i=universityMapper.checkReg(university);
        return i;
    }
//登录
    @Override
    public List<University> checkLogin(University university) {
        List<University> universities=universityMapper.checkLogin(university);
        return universities;
    }
    //查询学校名字
    @Override
    public List<University> fileName(University university) {
        List<University> files= universityMapper.fileName(university);
        return files;
    }
//添加学生信息
    @Override
    public int checkAdd(ArrayList<User> users) {
        int i=universityMapper.checkAdd(users);
        return i;
    }


}

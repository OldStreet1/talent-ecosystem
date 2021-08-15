package com.street.service.impl;

import com.street.bean.Resume;
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

    @Override
    public List<User> selectIDcard(String user_id_card) {
        List<User> selectIDcard=universityMapper.selectIDcard(user_id_card);
        return selectIDcard;
    }


    //添加学生信息
    @Override
    public int checkAdd(ArrayList<User> users) {
        int j=universityMapper.checkAdd(users);
        return j;
    }

    //查询用户
    @Override
    public ArrayList<User> queryUser(User user) {
        ArrayList<User>users=universityMapper.queryUser(user);
        return users;
    }
//查询专业
    @Override
    public ArrayList<User> queryMajor(User user) {
        ArrayList<User>majors=universityMapper.queryMajor(user);
        return majors;
    }
//按专业查询学生
    @Override
    public ArrayList<User> screenUser(User user) {
        ArrayList<User>screenUser=universityMapper.screenUser(user);
        return screenUser;
    }
//查询高校简介
    @Override
    public ArrayList<University> queryProfile(University university) {
        ArrayList<University>queryProfile=universityMapper.queryProfile(university);
        return queryProfile;
    }

    @Override
    public int resume(ArrayList<Resume> resumes) {
        int i=universityMapper.resume(resumes);
        return i;
    }
}

package com.street.mapper;

import com.street.bean.Resume;
import com.street.bean.University;
import com.street.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: xiaozheng
 * @date: 2021/7/26 14:45
 * @desc:
 */
@Repository
public interface UniversityMapper {
    //注册
    int checkReg(University university);

    //登录
    List<University> checkLogin(University university);
//查询学校名字
    List<University> fileName(University university);

    //    添加
    int checkAdd(ArrayList<User> users);

    //查询用户
    ArrayList<User> queryUser(User user);

    //查询学生用户专业
    ArrayList<User> queryMajor(User user);

    //按专业查询学生
    ArrayList<User> screenUser(User user);

    //查询高校简介
    ArrayList<University>queryProfile(University university);

    //添加简历
    int resume(ArrayList<Resume> resumes);
}

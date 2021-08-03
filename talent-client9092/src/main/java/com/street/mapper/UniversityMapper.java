package com.street.mapper;

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
}

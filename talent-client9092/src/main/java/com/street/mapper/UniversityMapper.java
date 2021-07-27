package com.street.mapper;

import com.street.bean.University;
import org.springframework.stereotype.Repository;

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
}

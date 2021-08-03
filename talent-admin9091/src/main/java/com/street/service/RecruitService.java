package com.street.service;

import com.street.mapper.RecruitMapper;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/31 22:46
 * @desc:
 */
public interface RecruitService {
    //通过字段查找企业信息
    public List<RuntimeException> queryRecruit(String info);
}

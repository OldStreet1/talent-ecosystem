package com.street.service;

import com.street.bean.Recruit;

import java.util.List;

public interface RecruitService {
    // 热门招聘查询
    List<Recruit> HotRecruit();
    // 职位搜索
    List<Recruit> QueryRecruit(Recruit recruit);
}

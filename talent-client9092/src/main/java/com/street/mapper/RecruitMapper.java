package com.street.mapper;

import com.street.bean.Recruit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitMapper {
    // 热门招聘查询
    List<Recruit> HotRecruit();
    // 职位搜索
    List<Recruit> QueryRecruit(Recruit recruit);
    // 查询所有职位
    List<Recruit> AllRecruit();
}

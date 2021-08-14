package com.street.mapper;

import com.street.bean.Recruit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitMapper {
    // 热门招聘查询
    List<Recruit> HotRecruit();
    // 职位查询
    List<Recruit> QueryRecruit(Recruit recruit);
}

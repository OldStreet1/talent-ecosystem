package com.street.service;

import com.street.bean.RecuitEnterprise;
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
    //通过id查找企业信息
    public List<RuntimeException> queryRecruitID(String recruit_id);
    //搜索框搜索
    public List<RecuitEnterprise> querysearchall(RecuitEnterprise runtimeException);
}

package com.street.service.impl;

import com.street.bean.RecuitEnterprise;
import com.street.mapper.RecruitMapper;
import com.street.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/31 22:47
 * @desc:
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    public RecruitMapper recruitMapper;

    @Override
    public List<RuntimeException> queryRecruit(String info) {
        return recruitMapper.queryRecruit(info);
    }

    @Override
    public List<RuntimeException> queryRecruitID(String recruit_id) {
        return recruitMapper.queryRecruitID(recruit_id);
    }

    @Override
    public List<RecuitEnterprise> querysearchall(RecuitEnterprise runtimeException) {
        return recruitMapper.querysearchall(runtimeException);
    }

    @Override
    public List<RecuitEnterprise> selectEnterpriseAdopt(Map<String, String> info) {
        return recruitMapper.selectEnterpriseAdopt(info);
    }
}

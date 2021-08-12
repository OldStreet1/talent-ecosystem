package com.street.mapper;

import com.street.bean.RecuitEnterprise;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/31 22:43
 * @desc:
 */
@Repository
public interface RecruitMapper {
    //通过字段查找企业信息
    public List<RuntimeException> queryRecruit(String info);
    //通过id查找企业信息
    public List<RuntimeException> queryRecruitID(String recruit_id);

    //搜索框搜索
    public List<RecuitEnterprise> querysearchall(RecuitEnterprise runtimeException);

    //查询通过的企业
    List<RecuitEnterprise> selectEnterpriseAdopt(Map<String,String> info);

    //通过id查找企业
    List<RecuitEnterprise> selectEnterpriseAdoptid(Map<String,String> info);
}

package com.street.mapper;

import com.street.bean.Enterprise;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/27 09:08
 * @desc:
 */
@Repository
public interface EnterprideMapper {
    //企业注册
    int addEnterpride(Enterprise enterprise);
}

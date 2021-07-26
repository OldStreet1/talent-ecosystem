package com.street.mapper;

import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/26 14:23
 * @desc:
 */
@Repository
public interface ParameterMapper {
    //通过name查找value
    String queryValue(String name);
}

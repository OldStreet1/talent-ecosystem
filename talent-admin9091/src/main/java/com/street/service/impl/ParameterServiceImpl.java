package com.street.service.impl;

import com.street.mapper.ParameterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/30 10:40
 * @desc:
 */
@Service
public class ParameterServiceImpl implements ParameterMapper {
    @Autowired
    private ParameterMapper parameterMapper;

    @Override
    public String queryValue(String name) {
        return parameterMapper.queryValue(name);
    }
}

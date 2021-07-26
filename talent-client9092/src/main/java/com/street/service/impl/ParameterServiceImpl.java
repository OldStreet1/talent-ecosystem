package com.street.service.impl;

import com.street.mapper.ParameterMapper;
import com.street.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/26 14:24
 * @desc:
 */
@Service
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    private ParameterMapper parameterMapper;

    @Override
    public String queryValue(String name) {
        return parameterMapper.queryValue(name);
    }
}

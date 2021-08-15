package com.street.service;

import com.street.bean.AlipayBean;

import java.io.IOException;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/27 15:14
 * @desc:
 */
public interface PayService {
    String toAlipay(AlipayBean alipayBean) throws IOException;
}

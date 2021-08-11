package com.street.service;

import com.street.bean.Delivery;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/8/8 13:36
 * @desc:
 */
public interface DeliveryService {
    //添加新的字段
    int addDelivery(Delivery delivery);
    //查找数据是否已经存在
    Delivery selectDelivery(Delivery delivery);
}

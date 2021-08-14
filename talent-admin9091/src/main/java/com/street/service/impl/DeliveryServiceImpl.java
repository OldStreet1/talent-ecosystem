package com.street.service.impl;

import com.street.bean.Delivery;
import com.street.mapper.DeliveryMapper;
import com.street.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/8/8 13:37
 * @desc:
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryMapper deliveryMapper;


    @Override
    public int addDelivery(Delivery delivery) {
        return deliveryMapper.addDelivery(delivery);
    }

    @Override
    public Delivery selectDelivery(Delivery delivery) {
        return deliveryMapper.selectDelivery(delivery);
    }
}

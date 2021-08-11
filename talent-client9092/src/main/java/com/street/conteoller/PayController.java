package com.street.conteoller;

import com.street.bean.AlipayBean;
import com.street.config.AlipayConfig;
import com.street.service.impl.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/27 15:30
 * @desc:
 */
@RestController
public class PayController {
    @Autowired
    private PayServiceImpl payService;
    @Autowired
    AlipayConfig alipayConfig;

    @PostMapping("alipay")
    public String toAlipay(@RequestBody AlipayBean alipayBean) throws IOException {
        System.out.println(alipayBean);
        String result = payService.toAlipay(alipayBean);
//        System.out.println(result);
        return result;
    }

}

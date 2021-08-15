package com.street.conteoller;

import com.street.bean.AlipayBean;
import com.street.config.AlipayConfig;
import com.street.service.impl.EnterprideServiceImpl;
import com.street.service.impl.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private EnterprideServiceImpl enterprideServiceImpl;
    @Autowired
    HttpServletRequest request; //通过注解获取一个request

    @PostMapping("alipay")
    public String toAlipay(@RequestBody AlipayBean alipayBean ) throws IOException {
        System.out.println(alipayBean);
        System.out.println("多少钱："+alipayBean.getTotal_amount());
//        String enterprise_acc = request.getParameter("enterprise_acc");
        String enterprise_acc = String.valueOf(request.getSession().getAttribute("enterprise_acc"));
        System.out.println("账户："+enterprise_acc);
        enterprideServiceImpl.increaseEnterprideBalance(String.valueOf(alipayBean.getTotal_amount() * 10),enterprise_acc);
        String result = payService.toAlipay(alipayBean);
//        System.out.println(result);
        return result;
    }

}

package com.street.conteoller;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.street.bean.Enterprise;
import com.street.service.impl.EnterprideServiceImpl;
import javafx.scene.chart.PieChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/26 09:07
 * @desc:
 */
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterprideServiceImpl enterprideServiceImpl;

    //企业请求登陆"
    @PostMapping("/login")
    public String EnterprideLogin(Enterprise enterprise){
        System.err.println("企业请求登陆");
        System.out.println(enterprise);
        return "success";
    }

    //企业注册
    @PostMapping("/register")
    public String EnterprideRegister(Enterprise enterprise){
        Date d = new Date();
        SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sbf.format(d));
        enterprise.setCreate_time(sbf.format(d));
//       查询企业是否存在


        int a = enterprideServiceImpl.addEnterpride(enterprise);
        if (a == 1){
            return "success";
        }else {
            return "errrrr";
        }

    }



}

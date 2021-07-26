package com.street.conteoller;

import com.street.bean.Enterprise;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/26 09:07
 * @desc:
 */
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @PostMapping("/login")
    public String EnterprideLogin(Enterprise enterprise){
        System.err.println("企业请求登陆");
        System.out.println(enterprise);
        return "success";
    }

}

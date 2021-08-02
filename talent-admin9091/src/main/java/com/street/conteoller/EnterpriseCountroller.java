package com.street.conteoller;

import com.street.bean.Enterprise;
import com.street.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/enter")
public class EnterpriseCountroller {
    @Autowired
    private EnterpriseService enterpriseService;

    @ResponseBody
    @RequestMapping("/enterchaxun")
    public Enterprise enterprise(){
//        实例化
        Enterprise enterprise = new Enterprise();
//        调用数组实例化方法
        List<Enterprise> epallchaxun = enterpriseService.epallchaxun();
//        输出长度
        System.out.println(epallchaxun.size());
//        拿到第0个==第一行数据
        return enterprise;
    }
}

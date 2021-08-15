package com.street.conteoller;

import com.street.bean.Enterprise;
import com.street.service.impl.EnterpriseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/enter")
public class EnterpriseController {
    @Autowired
    private EnterpriseServiceImpl enterpriseService;

    @ResponseBody
    @RequestMapping("/enterchaxun")
    public List<Enterprise> enterprise(){
        //        实例化
        Enterprise enterprise = new Enterprise();
//        调用实例化方法
        List<Enterprise> epallchaxun = enterpriseService.epallchaxun();
//        拿到第0个==第一行数据
        return epallchaxun;
    }



}

package com.street.conteoller;

import com.street.bean.Enterprise;
import com.street.bean.Recruit;
import com.street.service.impl.EnterprideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        if (enterprideServiceImpl.enterprideLogin(enterprise).isEmpty()){
            return "errrr";
        }else {
            return "success";
        }

    }

    //企业注册
    @PostMapping("/register")
    public String EnterprideRegister(Enterprise enterprise){
        Date d = new Date();
        SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sbf.format(d));
        enterprise.setCreate_time(sbf.format(d));
//       查询企业是否存在
        if(enterprideServiceImpl.queryEnterpride(enterprise.getEnterprise_acc()).isEmpty()){
            int a = enterprideServiceImpl.addEnterpride(enterprise);
            if (a == 1){
                return "success";
            }else {
                return "errrrr";
            }
        }else{
            return "existence";
        }
    }

    // 热门企业查询
    @PostMapping("/hotEnterprise")
    public List<Enterprise> HotEnterpriseQuery(){
        System.err.println("2>>>>>>>>>>>>>>>热门企业查询");
        List<Enterprise> enterprises = enterprideServiceImpl.HotEnterprise();
        System.out.println(enterprises.size());
        return enterprises;
    }

}

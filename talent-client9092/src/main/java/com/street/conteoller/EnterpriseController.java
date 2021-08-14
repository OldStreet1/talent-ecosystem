package com.street.conteoller;

import com.street.bean.Enterprise;
import com.street.service.impl.EnterprideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String EnterprideLogin(Enterprise enterprise, HttpServletRequest request){
        System.err.println("企业请求登陆");
        if (enterprideServiceImpl.enterprideLogin(enterprise).isEmpty()){
            return "errrr";
        }else {
            HttpSession session =request.getSession();
            session.setAttribute("enterprise_acc",enterprise.getEnterprise_acc());
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

    //企业坐标
    @PostMapping("/center")
    public String EnterprideCenter(Enterprise enterprise){
        String name = "美柚";
        enterprise.setEnterprise_name(name);
        String enterprise_coordinate = enterprideServiceImpl.queryEnterpriseCoordinate(name);
        System.out.println(enterprise_coordinate);
        return enterprise_coordinate;
    }
    //企业信息
    @PostMapping("/data")
    public List<Enterprise> EnterprideData(Enterprise enterprise ,HttpServletRequest request){
        String enterprise_acc = String.valueOf(request.getSession().getAttribute("enterprise_acc"));
        System.out.println(enterprise_acc);
        List<Enterprise> enterpriseList = enterprideServiceImpl.queryEnterprideData(enterprise.getEnterprise_acc());
//        System.out.println(enterpriseList.get(0).getEnterprise_name());
        return enterpriseList;
    }

    //企业简介
    @PostMapping("/intro")
    public List<Enterprise> EnterprideIntro(HttpServletRequest request){
        String enterprise_name = request.getParameter("enterprise_name");
        System.out.println(enterprise_name);
        List<Enterprise> enterprises = enterprideServiceImpl.queryEnterprideIntro(enterprise_name);
        System.out.println(enterprises.get(0).getEnterprise_time_establishment());
//        System.out.println(enterpriseList.get(0).getEnterprise_name());
        return enterprises;
    }


}

package com.street.conteoller;

import com.street.bean.Admin;
import com.street.bean.Menu;
import com.street.service.impl.AdminServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminControl {
    @Autowired
    private AdminServiceImpl adminServiceImpl;

    //后台请求登陆
    @PostMapping("/AdminLogin")
    @ResponseBody
    public String AdminLogin(Admin admin) {
//        System.err.println("后台管理请求登录");
        System.out.println("后台管理请求登录");
        if (adminServiceImpl.AdminLogin(admin).isEmpty()) {
            return "errrr";
        } else {
            return "sccess";
        }

    }

    //后台管理注册
    @PostMapping("/register")
    public String AdminAdd(Admin admin) {
        Date d = new Date();
        SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sbf.format(d));
        admin.setUpdate_time(sbf.format(d));
//       查询用户是否存在
        if (adminServiceImpl.UserSelect(admin.getAdmin_account()).isEmpty()) {
            int a = adminServiceImpl.AdminAdd(admin);
            if (a == 1) {
                return "success";
            } else {
                return "errrrr";
            }
        } else {
            return "existence";
        }


    }

    //后台动态菜单栏
//    @PostMapping("/Menu")
//    public String MenuAdd(Menu menu) {
//
//    }

}

package com.street.conteoller;

import com.street.bean.Admin;
import com.street.dto.AdminDto;
import com.street.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Admin")
public class AdminControl {
    @Autowired
    private AdminServiceImpl adminServiceImpl;

    //后台请求登陆
    @PostMapping("/AdminLogin")
    @ResponseBody
    public Map<String,Object>  AdminLogin(Admin admin) {

        System.out.println("后台管理请求登录");
        Map<String,Object> map=new HashMap<>();
        AdminDto admins=adminServiceImpl.AdminLogin(admin);
        String isLoginSuceess=null;
        if (admins==null) {
            isLoginSuceess="error";
        } else {
            isLoginSuceess="success";
        }
        map.put("isLoginSuceess",isLoginSuceess);
        map.put("admins",admins);
        return map;
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

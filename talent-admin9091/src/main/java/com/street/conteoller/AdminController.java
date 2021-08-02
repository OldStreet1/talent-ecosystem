package com.street.conteoller;

import com.street.bean.Admin;
import com.street.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @ResponseBody
    @RequestMapping("/adminchaxun")
    public List<Admin> admin(){
        System.out.println("0000");
        Admin admin = new Admin();
        List<Admin> allchaxun = adminService.allchaxun();
//        System.out.println(allchaxun.size());
//        System.out.println(allchaxun);
        return allchaxun;
    }

    @ResponseBody
    @RequestMapping("/adminxiugai")
    public List<Admin> xiugai(){
//        System.out.println("0000");
        Admin admin = new Admin();
        List<Admin> allchaxun = adminService.allchaxun();
        System.out.println(allchaxun.size());
        System.out.println(allchaxun);
        return allchaxun;
    }
}

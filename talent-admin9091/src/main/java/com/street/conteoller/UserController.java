package com.street.conteoller;


import com.street.bean.User;
import com.street.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/23 22:47
 * @desc:
 * @yyds: jiashen
 */
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/user1")
    public User user(){
        User user = new User();
        List<User> queryall = userServiceImpl.queryall();
        System.out.println(queryall.size());
        return queryall.get(0);
    }




}

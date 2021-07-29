package com.street.conteoller;

import com.alibaba.fastjson.JSONObject;
import com.street.bean.User;
import com.street.bean.WeChatConfig;
import com.street.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/29 09:59
 * @desc:
 */
@RestController
public class WXController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/test")
    public String user(){
        System.out.println("");
        System.out.println("123");
        return "123";

    }

    @GetMapping("/login/applets")
    public String appletsLogin(@RequestParam("code") String code) {
        // 调用接口
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("appid", "wxcbc8787aa1ad7f6d");
        paramMap.put("secret", "1aa5318303dccfdb90f8b25eb48d6b57");
        paramMap.put("code",code);
        System.err.println(code);
        System.err.println(paramMap);
        String result = this.restTemplate.getForObject(url, String.class, paramMap);
        System.out.println(result);
        return result;

    }

    @PostMapping("/openid")
    @ResponseBody
    public String getByUserId(@RequestBody Map<String, String> req){
        System.out.println(req.get("openid"));
        List<User> queryall = userServiceImpl.queryall();
        System.err.println(queryall);
        return "123";
    }


}

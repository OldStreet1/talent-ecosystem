package com.street.conteoller;

import com.alibaba.fastjson.JSONObject;
import com.street.bean.User;
import com.street.bean.WeChatConfig;
import com.street.service.impl.ParameterServiceImpl;
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
    @Autowired
    private ParameterServiceImpl parameterService;

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
        System.out.println(parameterService.queryValue("AppID")+"+++++++");
        System.out.println(parameterService.queryValue("AppSecret")+"+++++++");
        paramMap.put("appid", parameterService.queryValue("AppID"));
        paramMap.put("secret", parameterService.queryValue("AppSecret"));
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
        List<User> queryall = userServiceImpl.queryUser(req.get("openid"));
        System.err.println(queryall);
        String userInfo = JSONObject.toJSONString(queryall);
        return userInfo;
    }


}

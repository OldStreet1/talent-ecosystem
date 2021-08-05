package com.street.conteoller;

import com.alibaba.fastjson.JSONObject;
import com.street.bean.RecuitEnterprise;
import com.street.bean.User;
import com.street.bean.WeChatConfig;
import com.street.mapper.RecruitMapper;
import com.street.service.impl.ParameterServiceImpl;
import com.street.service.impl.RecruitServiceImpl;
import com.street.service.impl.UserServiceImpl;
import com.street.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RecruitMapper recruitMapper;
    @Autowired
    private RecruitServiceImpl recruitService;
    @Autowired
    private SendSms sendSms;
    @Autowired
    private RecuitEnterprise recuitEnterprise;
    // 注入redis操作模板
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

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
        paramMap.put("appid", parameterService.queryValue("AppID"));
        paramMap.put("secret", parameterService.queryValue("AppSecret"));
        paramMap.put("code",code);
        String result = this.restTemplate.getForObject(url, String.class, paramMap);
        return result;

    }

    @PostMapping("/openid")
    @ResponseBody
    public String getByUserId(@RequestBody Map<String, String> req){
        List<User> queryall = userServiceImpl.queryUser(req.get("openid"));
        String userInfo = JSONObject.toJSONString(queryall);
        if (queryall.isEmpty()){
            return "nothingness";
        }else {
            return userInfo;
        }

    }

    //首页页面的招聘信息显示
    @PostMapping("/recruitInfo")
    @ResponseBody
    public String recruitInfo(@RequestBody Map<String, String> req){
        System.out.println(req.get("position"));
        List<RuntimeException> recruitMappers = recruitMapper.queryRecruit("123");
        String s = JSONObject.toJSONString(recruitMappers);
        return s;
    }


    //手机验证登陆
    @PostMapping("/phoneSmsLogin")
    @ResponseBody
    public String phoneSmsLogin(@RequestBody Map<String, String> req){
        // 获取到操作String的对象验证码
        String code  = redisTemplate.opsForValue().get(req.get("phone"));
        //手机号
        String phone = req.get("phone");
        //用户输入验证码
        String sms = req.get("sms");
        //oppenid
        String openid = req.get("openid");
        String img = req.get("img");

        if (sms.equals(code)){
            //判断手机号是否数据库是否存在
            List<User> users = userServiceImpl.queryphoneUser(phone);
            if(!users.isEmpty()){
                //手机号存在 合并信息
                users.get(0).setOpenid(openid);
                users.get(0).setUserimg(img);
                userServiceImpl.updeteopenid(users.get(0));
                String s = JSONObject.toJSONString(users);
                return s;
            }else {
                //手机号不存在
                return "success";
            }
        }else {
            return "fail";
        }


    }

//    发送验证码
    @PostMapping("/sendSms")
    @ResponseBody
    public String sendSms(@RequestBody Map<String, String> req) throws Exception {
//        // 获取到操作String的对象
//        String code  = redisTemplate.opsForValue().get(req.get("phone"));
//        if (StringUtils.isEmpty(code)) {
            // 生成6位随机数
             String code = String.valueOf(Math.random()).substring(3, 9);
            System.out.println(code);
            // 将redisTemplate模板对象的key的序列化方式修改为new StringRedisSerializer
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            // 将phone当做key，将code当做value存进redis中，时间为5分钟
            redisTemplate.opsForValue().set(req.get("phone"), code, 5, TimeUnit.MINUTES);
            // 调用业务层接口 发送验证码
//            boolean sendSmsFlag = sendSms.sendSmsCode(req.get("phone"), code);
            return "success";
//        }else {
//            System.out.println(redisTemplate.getExpire(req.get("phone")));
//            return ""+redisTemplate.getExpire(req.get("phone"));
//        }
    }


    //通过id查询企业和招聘信息
    @PostMapping("/queryRecruitID")
    @ResponseBody
    public String queryRecruitID(@RequestBody Map<String, String> req){
        System.out.println(req.get("id"));
        List<RuntimeException> recruitMappers = recruitMapper.queryRecruitID(req.get("id"));
        System.out.println(recruitMappers);
        String s = JSONObject.toJSONString(recruitMappers);
        return s;
    }

    //搜索框搜索
    @PostMapping("/querysearchall")
    @ResponseBody
    public String querysearchall(@RequestBody Map<String, String> req){
        recuitEnterprise.setEnterprise_name(req.get("id"));
        recuitEnterprise.setPosition(req.get("id"));
        String s = JSONObject.toJSONString(recruitService.querysearchall(recuitEnterprise));
        return s;
    }


    //简历投递



}

package com.street.conteoller;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.street.service.impl.ParameterServiceImpl;
import com.street.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/26 14:17
 * @desc:
 */
@RestController
@RequestMapping("/sms")
public class SMSverificationController {
    @Autowired
    private ParameterServiceImpl parameterServiceImpl;
    // 注入redis操作模板
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private SendSms sendSms;



    @PostMapping("/smsverification")
    public String SMSverification(String cellPhoneNum) throws Exception {
        System.err.println("发送验证码");
        System.out.println("发送验证码"+cellPhoneNum);
        System.out.println(parameterServiceImpl.queryValue("accessKeyID"));
        System.out.println(parameterServiceImpl.queryValue("accesskeyScret"));

        // 获取到操作String的对象
        String code  = redisTemplate.opsForValue().get(cellPhoneNum);
        // 如果手机号在redis中不存在的话才进行发送验证码操作
        if (StringUtils.isEmpty(code)) {
            // 生成6位随机数
            code = String.valueOf(Math.random()).substring(3, 9);
            System.out.println(code);
            // 将redisTemplate模板对象的key的序列化方式修改为new StringRedisSerializer
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            // 将phone当做key，将code当做value存进redis中，时间为5分钟
            redisTemplate.opsForValue().set(cellPhoneNum, code, 1, TimeUnit.MINUTES);
            // 调用业务层接口 发送验证码
            boolean sendSmsFlag = sendSms.sendSmsCode(cellPhoneNum, code);
            return "success";
        }else {
            System.out.println(redisTemplate.getExpire(cellPhoneNum));
            return ""+redisTemplate.getExpire(cellPhoneNum);
        }



    }




}

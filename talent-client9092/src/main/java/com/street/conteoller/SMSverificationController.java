package com.street.conteoller;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.street.service.impl.ParameterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/smsverification")
    public String SMSverification(String cellPhoneNum) throws Exception {
        System.err.println("发送验证码");
        System.out.println("发送验证码"+cellPhoneNum);
        System.out.println(parameterServiceImpl.queryValue("accessKeyID"));
        System.out.println(parameterServiceImpl.queryValue("accesskeyScret"));

//        com.aliyun.dysmsapi20170525.Client client = createClient(parameterServiceImpl.queryValue("accessKeyID"), parameterServiceImpl.queryValue("accesskeyScret"));
//        SendSmsRequest sendSmsRequest = new SendSmsRequest()
//                .setPhoneNumbers(cellPhoneNum)
//                .setSignName("我爱学习")
//                .setTemplateCode("SMS_219749033")
//                .setTemplateParam("{\"code\":\"1123\"}");
//        client.sendSms(sendSmsRequest);
        return "success";
    }


    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                .setAccessKeyId(accessKeyId)
                .setAccessKeySecret(accessKeySecret);
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

}

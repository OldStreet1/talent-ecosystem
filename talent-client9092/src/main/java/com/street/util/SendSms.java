package com.street.util;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.street.service.impl.ParameterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/8/3 13:24
 * @desc:
 */
@Component
public class SendSms {
    @Autowired
    private ParameterServiceImpl parameterServiceImpl;

    public boolean sendSmsCode(String cellPhoneNum,String code) throws Exception {
        System.out.println("执行发送验证码");
        com.aliyun.dysmsapi20170525.Client client = createClient(parameterServiceImpl.queryValue("accessKeyID"), parameterServiceImpl.queryValue("accesskeyScret"));
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(cellPhoneNum)
                .setSignName(parameterServiceImpl.queryValue("SignName"))
                .setTemplateCode(parameterServiceImpl.queryValue("TemplateCode"))
                .setTemplateParam("{\"code\":\""+code+"\"}");
        client.sendSms(sendSmsRequest);
        return true;
    }

    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                .setAccessKeyId(accessKeyId)
                .setAccessKeySecret(accessKeySecret);
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }
}

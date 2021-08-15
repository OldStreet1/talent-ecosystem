package com.street.service.impl;

//import com.alibaba.fastjson.JSON;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.request.AlipayTradePagePayRequest;
import com.street.bean.AlipayBean;
import com.street.config.AlipayConfig;
import com.street.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/27 15:16
 * @desc:
 */
//开启注解扫描配置文件
@EnableConfigurationProperties(AlipayConfig.class)
@Service
public class PayServiceImpl implements PayService {
    @Override
    public String toAlipay(AlipayBean alipayBean) throws IOException {
        return null;
    }
//    @Autowired
//    AlipayConfig alipayConfig;
//    @Override
//    public String toAlipay(AlipayBean alipayBean) throws IOException {
//        AlipayClient alipayClient = new DefaultAlipayClient(
//                alipayConfig.getGatewayUrl(),//支付宝网关
//                alipayConfig.getApp_id(),//appid
//                alipayConfig.getMerchant_private_key(),//商户私钥
//                alipayConfig.getFormate(),
//                alipayConfig.getCharset(),//字符编码格式
//                alipayConfig.getAlipay_public_key(),//支付宝公钥
//                alipayConfig.getSign_type());//签名方式
//        //2、设置请求参数
//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//        //页面跳转同步通知页面路径
//        alipayRequest.setReturnUrl(alipayConfig.getReturn_url());
//        // 服务器异步通知页面路径
//        alipayRequest.setNotifyUrl(alipayConfig.getNotify_url());
//        //封装参数
//        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
//        String result="";
//        try {
//            //3、请求支付宝进行付款，并获取支付结果
//            result  = alipayClient.pageExecute(alipayRequest).getBody();
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//        //返回付款信息
//        return result;
//    }
}



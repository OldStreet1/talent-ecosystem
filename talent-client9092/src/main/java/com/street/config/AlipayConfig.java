package com.street.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/27 15:00
 * @desc:
 */
@Configuration
@ConfigurationProperties(prefix = "alipayconfig",ignoreUnknownFields = false)
//@PropertySource("classpath:application.yml")//读取配置文件
@Component
public class AlipayConfig implements Serializable {
    // 应用ID
    private String app_id="2021000117694633";
    //商户私钥
    private String merchant_private_key="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCUT7XWsdyI8JVTHJTJnvjRRed5Y9CqCUWvtygtZzbQBqV90t1/v2QiqvAzxgNR5uZNrurdmCLM4aAaQpTAOtyVICzwof62ZHCVqJCLoYVkDq34Afk+U5DHstEM9KvpYraZBnZ3Z9wFQLAdyN1+yBVblrLvq7hTBbRPjY3JhYxI5n5qqPgadnbqmsmEiKiWUy97NTUQVuXGr/Ao927iPh5NfFCKTFlC1jMD9eqlcM7lqfAQUpH1WgocKR67gKvB9O+SFwKzH9FiOytnf+sYWVflqg7vRcwvN2ZeaT/a8+bfJGA0n6iRfWEn/+wAO27t8ql5k4hzHO8j4of9HDb3DJWZAgMBAAECggEAJrhgyvqIjx/wfFBb7/+XClvrwN90XNAq52M0FBZ8UvdJQX5J4c5AAGUMbRfnSfy0Z9eg7dWIUGEfgXuchktXx38s/G3uqAO0+P2XLz0uLB9BABzTy5fZlqlytqUyNK5W6cCsMSRmZuCqmjwUx8LJAK5pbPUyHErC9noIaHJ7W5Sb7vGMl1J7ecL+9JeEPDgCuAejAPlhAPBRvOw7qDKCIdx1YEuTpMFrBB279Cciy2rivj8esbzfQ6Qzj4gjtyodtrPq8MDnP0pfomOziqgAw5pCGXXeEby2h2ioy3JmIL/+onqc+xUmlyJamk7W9M0URbTlxrn4mgPK2Xq6uhBPmQKBgQDF9JtkpQvv/G5yfwy+MkQQCIsASy3wFXg939z8sFBdK0id0j2HIQeTSBgyog+O91UzUtuplwczAebciBIxXY0XqEooMTsM1aPeL3r+zojvnw4OTtMY0Iv8Y0XFXAF6O7L4UVO5xzPg+cYBsm/G1jexqqKrOXxIPjRvRiI0CVADMwKBgQC/zJnd5YZ+fPas6Nb2Rk+YVyEjfq7mZXXHVV9h4UfwxGGc7Ep9gIAyTwVtS2ut1Wi5XyVhbZ8KrxQ3q/CoqkffFTIP2hUBWhW/KHf7XVx9hxw7OOGqfQA29W9sMMwobKZ4ZhsTLq4j3FcJBqUBeyrWfb1QFEGX58x8hbKzDLFEAwKBgQCZpox7KVTDuSctfgoxEykbXNYvqysEAFYtiLap+FzYhIE/5vFVEsEjg8Esg/gZm0cpqDXSQ+UVpXNBV+jvIlMiusCcw+G2y5j/G9GXOE6317h8SJi32R/fDlsYnpqS+wWmktGvELzm8ljL9mmmZ54hLHZI+zzJgmcGu+ROia/uWwKBgQCLhlBsXns/arKbyGoQD8f5P3Do/FBJZIeQcWeIsbR+zq1f1Xi+4YrgjiGZh2MWuweKyk9MF825nPFtKlRQrkbIXwfjBjd/m0P0ooDdx+XvnykHX/Kx7msIj/T1VG4//gH/1e9ePfgKOFDMTRwd/raEAEaGiaXJ1qMn9q6vl80gdwKBgQCFa2/C2zksZAp0+QD+xrpq1a4MlseteoBLECK7DMc11gPPDl7pOW9g+SI0S/NVs29TPghNpw3mTAS3J4/svxVED6QEM+FGd+sDk22kjEPBI+FvLm/fgpOIbvkyey2X5JYiYYJAmZr9vQRewc9bXpvg64UJfoD7hEwbO6NPgQKnHQ==";
    //支付宝公钥
    private String alipay_public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsKPjlV8pVxHy6CjLpjYS0GUiRnS/rDXfHT67xVxbYFE+Xq/CVOJx5tNOaWvaDX6/PSWWIxoVTHkF1Rpb2WPrcfXAfOKsJ5Xf9z0oU3K0IOCAaIOnVvyiANieGNbjPHxfK46yqJjD1K4YPd+q/wlWe3BXe/2tzKYXpHX9Zzo5ap9kMvKe5FyiixB+pdhy11Ps4ii8oEperx4YVmuWQ6nhAs4yGLYsUxkTdrwEoy+2zwOCxIQuHA+9EBBJXj1pHK+GnNteNlzOOCyfmLu+MV9TadVCTwBzTTLik/jWnNtx6JgAoyiyUFyqf++hZFMYSNxWvMJpdw4B2YpF5vH/kKM/aQIDAQAB";
    //服务器异步通知页面路径
    private String notify_url= "http://localhost:8082/#/AInfo";
    //页面跳转同步通知页面路径
    private String return_url= "http://localhost:8082/#/AInfo";
    //签名方式
    private String sign_type="RSA2";
    //字符编码格式
    private String charset= "utf-8";
    //支付宝网关
    private String gatewayUrl= "https://openapi.alipaydev.com/gateway.do";
    /** 格式 */
    private String formate = "json";
    private String log_path= "C:\\";

    public AlipayConfig() {
    }

    public AlipayConfig(String app_id, String merchant_private_key, String alipay_public_key, String notify_url, String return_url, String sign_type, String charset, String gatewayUrl, String formate, String log_path) {
        this.app_id = app_id;
        this.merchant_private_key = merchant_private_key;
        this.alipay_public_key = alipay_public_key;
        this.notify_url = notify_url;
        this.return_url = return_url;
        this.sign_type = sign_type;
        this.charset = charset;
        this.gatewayUrl = gatewayUrl;
        this.formate = formate;
        this.log_path = log_path;
    }

    @Override
    public String toString() {
        return "AlipayConfig{" +
                "app_id='" + app_id + '\'' +
                ", merchant_private_key='" + merchant_private_key + '\'' +
                ", alipay_public_key='" + alipay_public_key + '\'' +
                ", notify_url='" + notify_url + '\'' +
                ", return_url='" + return_url + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", charset='" + charset + '\'' +
                ", gatewayUrl='" + gatewayUrl + '\'' +
                ", formate='" + formate + '\'' +
                ", log_path='" + log_path + '\'' +
                '}';
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getMerchant_private_key() {
        return merchant_private_key;
    }

    public void setMerchant_private_key(String merchant_private_key) {
        this.merchant_private_key = merchant_private_key;
    }

    public String getAlipay_public_key() {
        return alipay_public_key;
    }

    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public String getLog_path() {
        return log_path;
    }

    public void setLog_path(String log_path) {
        this.log_path = log_path;
    }
}

package com.street;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/24 20:15
 * @desc:
 */
@SpringBootApplication
@MapperScan("com.street.mapper")
public class ClientProvider9092 {
    public static void main(String[] args) {
        SpringApplication.run(ClientProvider9092.class,args);
    }
}

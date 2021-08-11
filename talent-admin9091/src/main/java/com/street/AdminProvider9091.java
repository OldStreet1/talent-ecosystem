package com.street;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/23 22:48
 * @desc:
 */

@SpringBootApplication
@MapperScan("com.street.mapper")
public class AdminProvider9091 {
    public static void main(String[] args) {
        SpringApplication.run(AdminProvider9091.class,args);
    }
}

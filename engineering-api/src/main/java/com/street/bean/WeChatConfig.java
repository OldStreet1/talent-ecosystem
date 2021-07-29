package com.street.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/29 15:05
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class WeChatConfig {

    private String appid;
    private String secret;
}

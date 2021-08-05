package com.street.bean;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/8/5 20:35
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)     //链式写法
@Component
public class Delivery {
    private int id;
    private String enid;
    private String reid;
    private String userid;
    private String state;
}

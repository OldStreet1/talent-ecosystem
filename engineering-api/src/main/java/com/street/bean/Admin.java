package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/22 19:23
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)     //链式写法
public class Admin {
    @ApiModelProperty(value = "主键Id")
    private int admin_id;

    @ApiModelProperty(value = "账号")
    private String university_name;

    @ApiModelProperty(value = "用户名")
    private String admin_account;

    @ApiModelProperty(value = "密码（加密）")
    private String admin_password;

    @ApiModelProperty(value = "用户名")
    private String admin_username;

    @ApiModelProperty(value = "权限（添加、删除）")
    private String admin_jurisdiction;

    @ApiModelProperty(value = "导入时间")
    private String create_time;

    @ApiModelProperty(value = "更新时间")
    private String update_time;
}

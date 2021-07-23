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
 * @date: 2021/7/22 19:18
 * @desc:
 */
@Data
@ApiModel(value = "高校实体类")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)     //链式写法
public class University {
    @ApiModelProperty(value = "主键Id")
    private int university_id;

    @ApiModelProperty(value = "学校名称")
    private String university_name;

    @ApiModelProperty(value = "校园代码")
    private String university_code;

    @ApiModelProperty(value = "法人身份证号")
    private String university_corporate_ID_number;

    @ApiModelProperty(value = "密码（加密）")
    private String university_password;

    @ApiModelProperty(value = "学校简介")
    private String university_profile;

    @ApiModelProperty(value = "导入时间")
    private String create_time;

    @ApiModelProperty(value = "更新时间")
    private String update_time;
}

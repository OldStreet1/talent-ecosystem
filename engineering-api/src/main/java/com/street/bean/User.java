package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/20 22:57
 * @desc:
 */
@Data

@ApiModel(value = "用户实体类")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)     //链式写法
public class User {

    @ApiModelProperty(value = "主键Id")
    private int user_id;

    @ApiModelProperty(value = "用户名")
    private String user_name;

    @ApiModelProperty(value = "密码（加密）")
    private String user_pwd;

    @ApiModelProperty(value = "身份证号")
    private String user_id_card;

    @ApiModelProperty(value = "民族")
    private String user_nation;

    @ApiModelProperty(value = "性别（身份证导入）")
    private String user_sex;

    @ApiModelProperty(value = "出生年月（身份证导入）")
    private String user_date_birth;

    @ApiModelProperty(value = "联系电话")
    private String user_telephone;

    @ApiModelProperty(value = "邮箱")
    private String user_mail;

    @ApiModelProperty(value = "学校名称")
    private String user_school_name;

    @ApiModelProperty(value = "专业")
    private String user_major;

    @ApiModelProperty(value = "学历")
    private String user_education;

    @ApiModelProperty(value = "居住地")
    private String user_residence;

    @ApiModelProperty(value = "毕业时间")
    private String user_graduation_time;

    @ApiModelProperty(value = "导入时间")
    private String create_time;

    @ApiModelProperty(value = "更新时间")
    private String update_time;

    @ApiModelProperty(value = "年龄")
    private String user_age;


}

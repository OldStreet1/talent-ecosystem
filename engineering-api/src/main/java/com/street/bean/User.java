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
    private int userid;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码（加密）")
    private String userpwd;

    @ApiModelProperty(value = "身份证号")
    private String useridcard;

    @ApiModelProperty(value = "民族")
    private String usernation;

    @ApiModelProperty(value = "性别（身份证导入）")
    private String usersex;

    @ApiModelProperty(value = "出生年月（身份证导入）")
    private String userdatebirth;

    @ApiModelProperty(value = "联系电话")
    private String usertelephone;

    @ApiModelProperty(value = "邮箱")
    private String usermail;

    @ApiModelProperty(value = "学校名称")
    private String userschoolname;

    @ApiModelProperty(value = "专业")
    private String usermajor;

    @ApiModelProperty(value = "学历")
    private String usereducation;

    @ApiModelProperty(value = "居住地")
    private String userresidence;

    @ApiModelProperty(value = "毕业时间")
    private String usergraduationtime;

    @ApiModelProperty(value = "导入时间")
    private String createtime;

    @ApiModelProperty(value = "更新时间")
    private String updatetime;

    @ApiModelProperty(value = "年龄")
    private String userage;

    @ApiModelProperty(value = "openid")
    private String openid;

    @ApiModelProperty(value = "userimg")
    private String userimg;


}

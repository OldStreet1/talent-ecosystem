package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/8/1 15:09
 * @desc:
 */
@Data
@ApiModel(value = "招聘实与企业体类")
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RecuitEnterprise {
    @ApiModelProperty(value = "主键Id")
    private int recruit_id;

    @ApiModelProperty(value = "岗位id")
    private String recruit_post_id;

    @ApiModelProperty(value = "企业类型")
    private String recruit_enterprise_type;

    @ApiModelProperty(value = "导入时间")
    private String create_time;

    @ApiModelProperty(value = "更新时间")
    private String update_time;

    @ApiModelProperty(value = "主键Id")
    private int enterprise_id;

    @ApiModelProperty(value = "企业名称")
    private String enterprise_name;

    @ApiModelProperty(value = "企业账号")
    private String enterprise_acc;

    @ApiModelProperty(value = "密码（加密）")
    private String enterprise_pwd;

    @ApiModelProperty(value = "确认密码（加密）")
    private String enterpriseConfirm_pwd;

    @ApiModelProperty(value = "企业地址")
    private String enterprise_address;

    @ApiModelProperty(value = "经营状态")
    private String enterprise_operation_status;

    @ApiModelProperty(value = "成立时间")
    private String enterprise_time_establishment;

    @ApiModelProperty(value = "企业法人")
    private String enterprise_legal_person;

    @ApiModelProperty(value = "企业代码")
    private String enterprise_code;

    @ApiModelProperty(value = "企业类型")
    private String enterprise_type;

    @ApiModelProperty(value = "企业规模")
    private String enterprise_scale;

    @ApiModelProperty(value = "招聘职位")
    private String enterprise_recruitment_position;

    @ApiModelProperty(value = "融资阶段")
    private String enterprise_financing_stage;

    @ApiModelProperty(value = "短信验证码")
    private String code;

    private String brief_introduction;

    private String contacts;

    private String phonenumber;

    private String contact_address;

    private String skills;

    private String position;

    private String salary;

    private String experience;

    private String education;

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
    private String user_email;

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

    @ApiModelProperty(value = "年龄")
    private String userage;

    @ApiModelProperty(value = "openid")
    private String openid;

    @ApiModelProperty(value = "userimg")
    private String userimg;

    private String enenen;

    private String id;

}

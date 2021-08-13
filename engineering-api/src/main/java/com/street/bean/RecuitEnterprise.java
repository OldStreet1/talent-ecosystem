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

}

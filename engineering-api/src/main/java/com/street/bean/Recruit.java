package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/22 19:35
 * @desc:
 */
@Data
@ApiModel(value = "招聘实体类")
@AllArgsConstructor
@NoArgsConstructor
public class Recruit {
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

    @ApiModelProperty(value = "简介")
    private String brief_introduction;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelProperty(value = "联系电话")
    private String phonenumber;

    @ApiModelProperty(value = "联系地址")
    private String contact_address;

    @ApiModelProperty(value = "掌握技能")
    private String skills;

    @ApiModelProperty(value = "招聘职位")
    private String position;

    @ApiModelProperty(value = "薪资")
    private String salary;

    @ApiModelProperty(value = "经验要求")
    private String experience;

    @ApiModelProperty(value = "学历要求")
    private String education;
}

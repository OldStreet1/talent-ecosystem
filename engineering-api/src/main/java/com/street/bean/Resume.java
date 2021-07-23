package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/22 19:41
 * @desc:
 */
@Data
@ApiModel(value = "简历实体类")
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    @ApiModelProperty(value = "主键Id")
    private int resume_id;

    @ApiModelProperty(value = "用户id")
    private String user_id;

    @ApiModelProperty(value = "用户名")
    private String user_name;

    @ApiModelProperty(value = "工作经历")
    private String work_exp;

    @ApiModelProperty(value = "求职意向")
    private String job_intention;

    @ApiModelProperty(value = "期望薪资")
    private String exp_salary;

    @ApiModelProperty(value = "教育背景")
    private String edu_back;

    @ApiModelProperty(value = "荣誉证书")
    private String honor_certify;

    @ApiModelProperty(value = "自我评价")
    private String self_appraisal;

    @ApiModelProperty(value = "兴趣爱好")
    private String hobbies;

    @ApiModelProperty(value = "家庭关系")
    private String family_ties;

    @ApiModelProperty(value = "导入时间")
    private String create_time;

    @ApiModelProperty(value = "更新时间")
    private String update_time;
}

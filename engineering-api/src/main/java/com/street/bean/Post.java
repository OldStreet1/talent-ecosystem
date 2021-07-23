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
 * @date: 2021/7/22 19:30
 * @desc:
 */
@Data
@ApiModel(value = "岗位实体类")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)     //链式写法
public class Post {
    @ApiModelProperty(value = "主键Id")
    private int post_id;

    @ApiModelProperty(value = "岗位名称")
    private String post_name;

    @ApiModelProperty(value = "岗位类型")
    private String post_type;

    @ApiModelProperty(value = "岗位薪资")
    private String post_salary;

    @ApiModelProperty(value = "学历要求")
    private String post_education_requirements;

    @ApiModelProperty(value = "工作地点")
    private String post_work_place;

    @ApiModelProperty(value = "要求工作经验")
    private String post_hands_on_background;

    @ApiModelProperty(value = "导入时间")
    private String create_time;

    @ApiModelProperty(value = "更新时间")
    private String update_time;
}

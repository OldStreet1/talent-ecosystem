package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/22 19:45
 * @desc:
 */
@Data
@ApiModel(value = "统计实体类")
@AllArgsConstructor
@NoArgsConstructor
public class Count {
    @ApiModelProperty(value = "主键Id")
    private int count_id;

    @ApiModelProperty(value = "高校人才总数")
    private String enter_user_sum;

    @ApiModelProperty(value = "岗位总数")
    private String post_sum;

    @ApiModelProperty(value = "求职人员总数")
    private String user_sum;

    @ApiModelProperty(value = "就业人数")
    private String employ_sum;

    @ApiModelProperty(value = "简历浏览次数")
    private String resume_bro_sum;

    @ApiModelProperty(value = "导入时间")
    private String create_time;

    @ApiModelProperty(value = "更新时间")
    private String update_time;

}

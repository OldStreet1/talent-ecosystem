package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/22 19:52
 * @desc:
 */
@Data
@ApiModel(value = "日志实体类")
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @ApiModelProperty(value = "主键Id")
    private int log_id;

    @ApiModelProperty(value = "日志名称")
    private String log_name;

    @ApiModelProperty(value = "日志类型")
    private String log_type;

    @ApiModelProperty(value = "生成时间")
    private String log_create_time;

    @ApiModelProperty(value = "最后修改时间")
    private String log_lastmodify_time;

    @ApiModelProperty(value = "日志内容")
    private String log_content;
}

package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/22 19:38
 * @desc:
 */
@Data
@ApiModel(value = "聊天实体类")
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @ApiModelProperty(value = "主键Id")
    private int chat_id;

    @ApiModelProperty(value = "发送者")
    private String chat_sender;

    @ApiModelProperty(value = "接收者")
    private String chat_receiver;

    @ApiModelProperty(value = "创建时间")
    private String chat_create_time;

    @ApiModelProperty(value = "最后修改时间")
    private String chat_lastmodify_time;

    @ApiModelProperty(value = "聊天记录")
    private String chat_record;
}

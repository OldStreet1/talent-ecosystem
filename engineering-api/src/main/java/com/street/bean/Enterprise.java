package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/22 14:54
 * @desc:
 */
@Data
@ApiModel(value = "企业实体类")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)     //链式写法
@Component
public class Enterprise {
    @ApiModelProperty(value = "主键Id")
    private int enterprise_id;

    @ApiModelProperty(value = "企业名称")
    private String enterprise_name;

    @ApiModelProperty(value = "企业账号")
    private String enterprise_acc;

    @ApiModelProperty(value = "密码（加密）")
    private String enterprise_pwd;

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

    @ApiModelProperty(value = "导入时间")
    private String create_time;

    @ApiModelProperty(value = "更新时间")
    private String update_time;

}

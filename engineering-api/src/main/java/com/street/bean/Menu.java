package com.street.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @author: zhen
 * @date: 2021/7/22 19:48
 * @desc:
 */
@Data
@ApiModel(value = "菜单实体类")
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @ApiModelProperty(value = "主键Id")
    private int menu_id;

    @ApiModelProperty(value = "菜单名称")
    private String menu_name;

    @ApiModelProperty(value = "父菜单ID")
    private String parent_id;

    @ApiModelProperty(value = "显示顺序")
    private String order_num;

    @ApiModelProperty(value = "路由地址")
    private String path;

    @ApiModelProperty(value = "组件路径")
    private String component;

    @ApiModelProperty(value = "是否为外链（0是 1否）")
    private String is_frame;

    @ApiModelProperty(value = "是否缓存（0缓存 1不缓存）")
    private String is_cache;

    @ApiModelProperty(value = "菜单类型（M目录 C菜单 F按钮）")
    private String menu_type;

    @ApiModelProperty(value = "菜单是否可见（0显示 1隐藏）")
    private String visible;

    @ApiModelProperty(value = "菜单状态（0正常 1停用）")
    private String status;

    @ApiModelProperty(value = "权限标识")
    private String perms;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "创建者")
    private String create_by;

    @ApiModelProperty(value = "创建时间")
    private String create_time;

    @ApiModelProperty(value = "更新者")
    private String update_by;

    @ApiModelProperty(value = "更新时间")
    private String update_time;

    @ApiModelProperty(value = "备注")
    private String remark;
}

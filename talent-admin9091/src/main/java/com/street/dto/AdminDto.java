package com.street.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminDto {

    private int adminId;


    private String universityName;


    private String adminAccount;


    private String adminPassword;


    private String adminUsername;


    private String adminJurisdiction;


    private String createTime;


    private String updateTime;


    private int adminRoleId;


    private String adminState;

    private String adminName;
}

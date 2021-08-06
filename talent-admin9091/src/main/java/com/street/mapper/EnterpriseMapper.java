package com.street.mapper;

import com.street.bean.Enterprise;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseMapper {
    List<Enterprise> epallchaxun();
    //    企业用户表 enterprise
    List<Enterprise> qyyhcharu();
    List<Enterprise> qyyhshanchu();
    List<Enterprise> qyyhxiugai();
    List<Enterprise> qyyhchaxun();
}

package com.street.mapper;

import com.street.bean.University;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityMapper {
    List<University> xyallchaxun();
    List<University> gxyhcharu();
    List<University> gxyhshanchu();
    List<University> gxyhxiugai();
    List<University> gxyhchaxun();
}

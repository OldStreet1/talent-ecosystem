package com.street.conteoller;

import com.street.bean.University;
import com.street.service.impl.UniversityImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @version 1.0
 * @author: xiaozheng
 * @date: 2021/7/26 15:54
 * @desc:
 */
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private UniversityImpl UniversityService;

    University university=new University();
    @RequestMapping("/getReg")
    public @ResponseBody String getReg(@Param("university_name") String university_name,
                                       @Param("university_code") String university_code,
                                       @Param("corporate_ID_number")String corporate_ID_number,
                                       @Param("university_password")String university_password,
                                       @Param("university_profile")String university_profile){
        System.out.println(">>>>>>>>>>>>>1111<<<<<<<<<<<<<<<<<<");

        university.setUniversity_name(university_name);
        university.setUniversity_code(university_code);
        university.setUniversity_corporate_ID_number(corporate_ID_number);
        university.setUniversity_password(university_password);
        university.setUniversity_profile(university_profile);

        int i= UniversityService.checkReg(university);
        if (i==1){
            System.out.println("注册成功");
            return "success";
        }else {
            return "0";
        }
    }
}

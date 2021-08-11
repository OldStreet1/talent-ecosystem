package com.street.conteoller;

import com.street.bean.University;
import com.street.service.impl.UniversityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    private UniversityServiceImpl universityService;

    @ResponseBody
    @RequestMapping("/unitychauxn")
    public List<University> universities(){
        System.out.println(">>>>>高校查询>>>>>>");
        University university = new University();
        List<University> schochaxun = universityService.xyallchaxun();
        System.out.println(schochaxun.size());
        return schochaxun;
    }
}

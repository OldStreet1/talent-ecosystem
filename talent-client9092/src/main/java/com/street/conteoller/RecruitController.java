package com.street.conteoller;

import com.street.bean.Recruit;
import com.street.service.impl.RecruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitServiceImpl recruitService;

    // 热门招聘查询
    @PostMapping("/hotRecruit")
    public List<Recruit> HotRecruitQuery(){
        System.err.println("1>>>>>>>>>>>>>>>热门招聘查询");
        List<Recruit> recruits = recruitService.HotRecruit();
        System.out.println(recruits.size());
        return recruits;
    }

    // 职位搜索
    @PostMapping("/queryRecruit")
    public List<Recruit> RecruitQuery(String position){
        System.err.println("3>>>>>>>>>>>>>>>职位搜索");
        Recruit recruit  = new Recruit();
        recruit.setPosition(position);
        List<Recruit> recruits = recruitService.QueryRecruit(recruit);
        System.out.println(recruits.size());
        return recruits;
    }

    // 查询所有职位
    @PostMapping("/recruits")
    public List<Recruit> AllRecruit(){
        System.err.println("4>>>>>>>>>>>>>>>查询所有职位");
        List<Recruit> recruits = recruitService.AllRecruit();
        System.out.println(recruits.size());
        return recruits;
    }

}

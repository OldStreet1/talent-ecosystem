package com.street.conteoller;

import com.street.bean.Recruit;
import com.street.bean.Resume;
import com.street.service.impl.RecruitServiceImpl;
import com.street.service.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeServiceImpl resumeService;

    // 查询所有简历
    @PostMapping("/resumes")
    public List<Resume> AllRecruit(){
        System.err.println("6>>>>>>>>>>>>>>>查询所有简历");
        List<Resume> Resumes = resumeService.AllResume();
        System.out.println(Resumes.size());
        return Resumes;
    }
}

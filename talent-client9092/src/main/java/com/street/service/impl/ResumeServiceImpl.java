package com.street.service.impl;

import com.street.bean.Resume;
import com.street.mapper.ResumeMapper;
import com.street.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public List<Resume> AllResume() {
        return resumeMapper.AllResume();
    }
}

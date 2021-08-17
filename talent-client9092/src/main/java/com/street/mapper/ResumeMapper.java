package com.street.mapper;

import com.street.bean.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeMapper {
    // 查询所有简历
    List<Resume> AllResume();
}

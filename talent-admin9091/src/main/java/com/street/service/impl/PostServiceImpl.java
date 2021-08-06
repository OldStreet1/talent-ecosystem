package com.street.service.impl;

import com.street.bean.Post;
import com.street.mapper.PostMapper;
import com.street.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> gwallchaxun() {
        return postMapper.gwallchaxun();
    }

    @Override
    public List<Post> gwchaxun() {
        return null;
    }

    @Override
    public List<Post> gwcharu() {
        return null;
    }

    @Override
    public List<Post> gwxiugai() {
        return null;
    }

    @Override
    public List<Post> gwshanchu() {
        return null;
    }
}

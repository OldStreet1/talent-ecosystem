package com.street.mapper;

import com.street.bean.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {
    List<Post> gwallchaxun();
    //    岗位相关
    List<Post> gwchaxun();
    List<Post> gwcharu();
    List<Post> gwxiugai();
    List<Post> gwshanchu();
}

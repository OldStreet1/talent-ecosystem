package com.street.conteoller;

import com.street.bean.Post;
import com.street.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
//    注入 ServiceImpl 的Service
    @Autowired
    private PostServiceImpl postService;

    @ResponseBody
    @RequestMapping("/postchaxun")
    public List<Post> post(){
        System.out.println(">>>>>岗位查询>>>>>");
        Post post = new Post();
        List<Post> gwallchaxun = postService.gwallchaxun();
        System.out.println(gwallchaxun.size());
        return gwallchaxun;
    }
    @ResponseBody
    @RequestMapping("postshanchu")
    public String postdelete(String post_name){
        System.out.println(">>post删除测试>>>");
        Post post = new Post();
        System.out.println(post_name);
        post.setPost_name(post_name);
        int i = postService.gwshanchu(post);
        System.out.println("post是否删除");
        return "success";
    }
}

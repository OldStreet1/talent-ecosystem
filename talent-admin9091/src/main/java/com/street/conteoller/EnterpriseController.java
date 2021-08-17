package com.street.conteoller;

import com.alibaba.fastjson.JSONObject;
import com.street.bean.Chat;
import com.street.bean.Enterprise;
import com.street.service.impl.ChatServiceImpl;
import com.street.service.impl.EnterpriseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/enter")
public class EnterpriseController {
    @Autowired
    private EnterpriseServiceImpl enterpriseService;
    @Autowired
    private ChatServiceImpl chatServiceImpl;

    @ResponseBody
    @RequestMapping("/enterchaxun")
    public List<Enterprise> enterprise(){
        //        实例化
        Enterprise enterprise = new Enterprise();
//        调用实例化方法
        List<Enterprise> epallchaxun = enterpriseService.epallchaxun();
//        拿到第0个==第一行数据
        return epallchaxun;

    }
    //获取聊天记录
    @PostMapping("/getchat")
    @ResponseBody
    public String queryChat(HttpServletRequest request){
        String receiver = request.getParameter("receiver");
        String sender = request.getParameter("sender");
        Chat chat = new Chat();
        chat.setChat_receiver(receiver);
        chat.setChat_sender(sender);
        List<Chat> chats = chatServiceImpl.queryChat(chat);
//        System.out.println("聊天记录："+chats);
        String s = JSONObject.toJSONString(chats);
        return s;
    }

    //聊天记录写入数据库
    @PostMapping("/addchat")
    @ResponseBody
    public String addChat(HttpServletRequest request){
        String message = request.getParameter("message");
        String[] data = message.split("&&");
        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);

        //将聊天记录存在数据库
        Chat chat = new Chat();
        chat.setChat_sender(data[0]);
        chat.setChat_receiver(data[1]);
        chat.setChat_record(data[2]);
//        System.out.println(chat);
        chatServiceImpl.addChat(chat);

        return "";
    }


}

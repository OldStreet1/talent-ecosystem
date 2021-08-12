package com.street.mapper;

import com.street.bean.Chat;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/8/11 22:35
 * @desc:
 */
@Repository
public interface ChatMapper {

    //新建聊天记录
    int addChat(Chat chat);

    //查询聊天
    List<Chat> queryChat(Chat chat);
}

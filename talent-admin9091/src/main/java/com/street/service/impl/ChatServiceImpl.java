package com.street.service.impl;

import com.street.bean.Chat;
import com.street.mapper.ChatMapper;
import com.street.service.ChatService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/8/11 22:36
 * @desc:
 */
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMapper chatMapper;

    @Override
    public int addChat(Chat chat) {
        return chatMapper.addChat(chat);
    }

    @Override
    public List<Chat> queryChat(Chat chat) {
        return chatMapper.queryChat(chat);
    }
}

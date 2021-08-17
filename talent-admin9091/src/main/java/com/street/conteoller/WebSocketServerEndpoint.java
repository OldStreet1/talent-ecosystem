package com.street.conteoller;

import com.street.bean.Chat;
import com.street.service.impl.ChatServiceImpl;
import okhttp3.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/8/10 19:54
 * @desc:
 */

@Component //加入web容器
@ServerEndpoint("/Websocket/{num}")
public class WebSocketServerEndpoint {


    //此处是解决无法注入的关键
    private static ApplicationContext applicationContext;


    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger onlineNum = new AtomicInteger();

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    private static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

    //发送消息
    public void sendMessage(Session session, String message) throws IOException {
        if(session != null){
            synchronized (session) {
//                System.out.println("发送数据：" + message);
                session.getBasicRemote().sendText(message);
            }
        }
    }
    //给指定用户发送信息
    public void sendInfo(String userName, String message){
        Session session = sessionPools.get(userName);
        try {
            sendMessage(session, message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //建立连接成功调用
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "num") String userName){
        System.out.println(sessionPools.get(userName));
        if (sessionPools.get(userName) == null){
            sessionPools.put(userName, session);
            addOnlineCount();
            System.out.println(session);
            System.out.println(userName + "加入webSocket！当前人数为" + onlineNum);
            try {
                sendMessage(session, "欢迎" + userName + "加入连接！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("已经存在无法建立链接");
        }


    }

    //关闭连接时调用
    @OnClose
    public void onClose(@PathParam(value = "num") String userName){
        sessionPools.remove(userName);
        subOnlineCount();
        System.out.println(userName + "断开webSocket连接！当前人数为" + onlineNum);
    }

    //收到客户端信息
    @OnMessage
    public void onMessage(String message) throws IOException{
//        message = "客户端：" + message + ",已收到";
        System.err.println(message);
        String[] data = message.split("&&");
        if (sessionPools.get(data[1]) == null){

        }else {
            sendMessage(sessionPools.get(data[1]),data[0]+"&&"+data[2]);
        }


//        for (Session session: sessionPools.values()) {
//            try {
//                sendMessage(session, message);
//            } catch(Exception e){
//                e.printStackTrace();
//                continue;
//            }
//        }
    }

    //错误时调用
    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }


}

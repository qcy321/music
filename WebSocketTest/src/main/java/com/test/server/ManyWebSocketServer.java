package com.test.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.responseUtil.R;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/many/{roomId}/{userId}")//原型模式，一个连接等于一个websocket
@Component
@Slf4j
public class ManyWebSocketServer {
    //用线程安全的map来存储数据
    private static ConcurrentHashMap<String, Set<Session>> websocketList = new ConcurrentHashMap<>();
    //接收sid
    private String userId = "";

    private Session session;

    private String roomId;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("roomId") String roomId, @PathParam("userId") String userId) {
        this.session = session;
        this.roomId = roomId;
        log.info("websocketList->" + JSON.toJSONString(websocketList));
        if (!websocketList.containsKey(roomId)) {
            Set<Session> set = new HashSet<>();
            set.add(session);
            websocketList.put(userId, set);
            log.info("当前房间号为:" + roomId + ",当前在线人数为" + set.size());
        } else {
            Set<Session> sessions = websocketList.get(roomId);
            sessions.add(session);
            log.info("当前房间号为:" + roomId + ",当前在线人数为" + sessions.size());
        }
        this.userId = userId;
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        Set<Session> sessions = websocketList.get(this.roomId);
        if (sessions != null) {
            sessions.remove(this.session);
            log.info("用户" + this.userId + "离开了" + this.roomId + "号房间，当前在线人数为" + sessions.size());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        if (StringUtils.isNotBlank(message)) {
            try {
                //解析发送的报文
                //JSONObject object = list.getJSONObject(i);
                JSONObject object = JSON.parseObject(message);
                String roomId = object.getString("roomId");
                String contentText = object.getString("contentText");
                object.put("fromUserId", this.userId);
                //传送给对应房间的websocket
                if (StringUtils.isNotBlank(roomId) && StringUtils.isNotBlank(contentText)) {
                    Set<Session> sessions = websocketList.get(roomId);
                    //需要进行转换，userId
                    if (sessions != null) {
                        for (Session session1 : sessions) {
                            session1.getBasicRemote().sendText(JSON.toJSONString(R.ok().data(object)));
                        }
                        //此处可以放置相关业务代码，例如存储到数据库
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }
}

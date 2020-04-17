package com.example.demo.socket;


import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Log
@Component
@ServerEndpoint(value="/websocket")
//,encoders = MessageEncoder.class, decoders = MessageDecoder.class) - 메세지 암복호화가 필요할때 사용
public class Socket {

    public static Set<Socket> listeners = new CopyOnWriteArraySet<>();
    private Session session;
    private static int onlineCount = 0;

    // 연결될때
    @OnOpen
    public void onOpen(Session session) throws IOException {
        log.info("onOpen 호출");
        // 접속자 증가
        addOnlineCount();
        this.session = session;

        System.out.println("접속정보 ?? --------------------------");
        System.out.println(session.getId());
        System.out.println("접속정보 ?? --------------------------");

        session.getBasicRemote().sendText("접속하셨습니다. >> ");


        listeners.add(this);
    }

    // 연결 종료시
    @OnClose
    public void onClose(Session session){
        log.info("onClose 호출");
        // 접속자 감소
        subOnlineCount();
        listeners.remove(this);
    }

    // 메세지 도착시
    @OnMessage
    public void onMessage(String message){
        log.info("onMessage : " +message);
        broadCast(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        Socket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        Socket.onlineCount--;
    }

    // 메세지 전달
    public static void broadCast(String message){
        for(Socket listener : listeners){
            listener.sendMessage(message);
        }
    }

    private void  sendMessage(String message){
        try{
            this.session.getBasicRemote().sendText(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

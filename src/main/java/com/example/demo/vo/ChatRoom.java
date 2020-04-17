package com.example.demo.vo;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class ChatRoom {

    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }

}

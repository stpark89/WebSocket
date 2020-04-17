package com.example.demo.controller;

import com.example.demo.entity.BoardEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.BoardService;
import com.example.demo.service.ChatRoomService;
import com.example.demo.vo.ChatRoom;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import java.util.List;

@Log
@RestController
public class DataController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping(value="/getBoardInfo")
    public BoardEntity getBoardInfo(Long boardId){
        return boardService.getBoard(boardId);
    }

    @GetMapping(value="/getBoardList")
    public List<ChatRoom> getBoardList(){
        log.info("방목록 조회 ---");
        return chatRoomService.findAllRoom();
    }

    /**
     * 방만들기
     * @return
     */
    @RequestMapping(value="/makeRoom")
    public ChatRoom makeRoom(ChatRoom chatRoom){
        log.info("방만들기 -- 새로만들어진 방의 아이디 가지고 입장해야함.");
        ChatRoom makeChatRoom = chatRoomService.createChatRoom(chatRoom.getName());
        return makeChatRoom;
    }

}

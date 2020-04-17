package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.BoardService;
import com.example.demo.service.ChatRoomService;
import com.example.demo.service.UserService;
import com.example.demo.socket.Socket;
import com.example.demo.vo.ChatRoom;
import com.example.demo.vo.ResponseVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Log
@Controller
public class ViewController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Autowired
    private ChatRoomService chatRoomService;

    @RequestMapping(value="/")
    public String index(Model model){
        log.info("로그인 페이지 ---");
        //model.addAttribute("member",Socket.getOnlineCount());
        return "login";
    }

    @RequestMapping(value="/sample")
    public String sample(){
        return "index";
    }

    @PostMapping(value="/loginData")
    public String loginData(UserEntity userEntity){

        log.info("여기 로그인 버튼 클릭시 ---");
        String returnUrl = "";

        ResponseVo responseVo = userService.getUserInfo(userEntity);

        if(responseVo.getResult().toString().equals("SUCCESS")){
            log.info("로그인 성공 !!");
            returnUrl = "redirect:/main";
        }else{
            log.info("로그인 실패 ---");
            returnUrl ="redirect:/";
        }
        return returnUrl;
    }

    @RequestMapping(value="/main")
    public String main(){
        log.info("main---");
        return "main";
    }

    @RequestMapping(value="/detailRoom/{roomId}")
    public String enterRoom(@PathVariable(value = "roomId") String roomId, Model model){

        log.info("방입장 --------------------------");
        log.info(roomId);

        ChatRoom detailRoom = chatRoomService.findRoomById(roomId);
        model.addAttribute("roomInfo", detailRoom);
        return "detailRoom";
    }

}

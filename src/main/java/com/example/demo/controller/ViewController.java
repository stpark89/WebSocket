package com.example.demo.controller;

import com.example.demo.socket.Socket;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@Controller
public class ViewController {

    @RequestMapping(value="/")
    public String index(Model model){
        log.info("메인 페이지 ---");
        model.addAttribute("member",Socket.getOnlineCount());
        return "index";
    }

}

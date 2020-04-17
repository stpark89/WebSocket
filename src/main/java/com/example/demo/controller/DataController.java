package com.example.demo.controller;

import com.example.demo.entity.BoardEntity;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value="/getBoardInfo")
    public BoardEntity getBoardInfo(Long boardId){
        return boardService.getBoard(boardId);
    }

}

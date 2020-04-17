package com.example.demo.service;


import com.example.demo.entity.BoardEntity;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public BoardEntity getBoard(Long boardId) {
        return boardRepository.findById(boardId).orElse(new BoardEntity());
    }

}

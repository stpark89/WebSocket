package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.vo.ResponseVo;
import com.example.demo.vo.ResultEnum;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseVo getUserInfo(UserEntity userEntity) {
        log.info("getUserInfo --");

        ResponseVo responseVo = new ResponseVo();

        UserEntity dbUserInfo = userRepository.findById(userEntity.getEmail()).orElse(null);

        if(dbUserInfo == null){
            log.info("유저 정보 없음 ----");
            responseVo.setResult(ResultEnum.FAIL);
            return responseVo;
        }

        // 비밀번호 검사.
        if(dbUserInfo.getPwd().equals(userEntity.getPwd())){
            responseVo.setResult(ResultEnum.SUCCESS);
        }else{
            responseVo.setResult(ResultEnum.FAIL);
        }
        return responseVo;
    }
}

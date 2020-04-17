package com.example.demo.socket;

import lombok.extern.java.Log;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

@Log
public class MessageDecoder implements Decoder.Text<String>{
    @Override
    public String decode(String s) throws DecodeException {
        log.info("MessageDecoder.decode");
        return null;
    }

    @Override
    public boolean willDecode(String s) {
        log.info("MessageDecoder.willDecode");
        return false;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        log.info("MessageDecoder.init");
    }

    @Override
    public void destroy() {
        log.info("MessageDecoder.destroy");
    }
}

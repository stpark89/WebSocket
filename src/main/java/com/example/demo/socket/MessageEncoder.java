package com.example.demo.socket;

import lombok.extern.java.Log;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

@Log
public class MessageEncoder implements Encoder.Text<String> {

    @Override
    public String encode(String s) throws EncodeException {
        log.info("MessageEncoder.encode");
        return null;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        log.info("MessageEncoder.init");
    }

    @Override
    public void destroy() {
        log.info("MessageEncoder.destroy");
    }
}

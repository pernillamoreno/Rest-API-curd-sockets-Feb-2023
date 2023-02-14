package com.example.gertruder.config;

import com.example.gertruder.ws.ChattRoomStateSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer {
    @Autowired
    private ChattRoomStateSocketHandler chattRoomStateSocketHandler;
    private final static String SOCKET_PREFIX = "";
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
       // registry.addHandler(ChattRoomStateSocketHandler, SOCKET_PREFIX + "");

    }
}

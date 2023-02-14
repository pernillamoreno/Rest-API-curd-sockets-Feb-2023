package com.example.gertruder.config;

import com.example.gertruder.ws.ChattRoomStateSocketHandler;
import com.example.gertruder.ws.MessRoomStateSocketHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@AllArgsConstructor
public class SocketConfig implements WebSocketConfigurer {
    @Autowired
    private ChattRoomStateSocketHandler chattRoomStateSocketHandler;

    private MessRoomStateSocketHandler messRoomStateSocketHandler;
    private final static String SOCKET_PREFIX = "/sub";
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
       registry.addHandler(chattRoomStateSocketHandler, SOCKET_PREFIX + "");
        registry.addHandler(messRoomStateSocketHandler, SOCKET_PREFIX + "");

    }
}

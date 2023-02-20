package com.example.gertruder.ws;

import com.example.gertruder.model.ChattRoom;
import com.example.gertruder.service.ChattRoomService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChattRoomStateSocketHandler extends TextWebSocketHandler {
    private final List<WebSocketSession> sessions = new ArrayList<>();
    @Autowired
    private ChattRoomService chattRoomService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)  {
        broadcast(message.getPayload(),session);
    }


    public void broadcast(String message,WebSocketSession webSocketSession) {
        try {
            for (WebSocketSession webSession : sessions) {
                webSession.sendMessage(new TextMessage(message));
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    public void broadcast(ChattRoom chatt){
        try {
            for (WebSocketSession webSession : sessions) {
                webSession.sendMessage(new TextMessage("Chatt" + chatt.getTitel() + "id created " + chatt.getId()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("New session created");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("Session was removed");
    }
}
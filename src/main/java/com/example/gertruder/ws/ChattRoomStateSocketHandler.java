package com.example.gertruder.ws;

import com.example.gertruder.model.ChattRoom;
import com.example.gertruder.service.ChattRoomService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ChattRoomStateSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ChattRoomService chattRoomService;
    private final List<WebSocketSession> sessions = new ArrayList<>();




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
                webSession.sendMessage(new TextMessage("Chatt " + chatt.getTitel() + "and id created:" + chatt.getId()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("New chattroom session created");


        List<ChattRoom> chattRooms = chattRoomService.getChattRoom();
        if(chattRooms != null || chattRooms.size() != 0 ){

            try {
                session.sendMessage(new TextMessage("Alive and kicking state chattrooms "));

                for (ChattRoom chattRoom  : chattRooms) {
                    session.sendMessage(new TextMessage(chattRoom.toString()));
                }

            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        }
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("Hasta la vista! ");
    }
}

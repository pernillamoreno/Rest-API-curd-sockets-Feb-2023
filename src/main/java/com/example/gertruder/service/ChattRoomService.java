package com.example.gertruder.service;

import com.example.gertruder.model.ChattRoom;
import com.example.gertruder.repository.JpaChattRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChattRoomService {

    public List <ChattRoom> getChattRooms() {return jpaChattRoomRepository.findAll();}

    public ChattRoom save(ChattRoom chattRoom) {return jpaChattRoomRepository.save(chattRoom);}
    
    public void delete(long id){jpaChattRoomRepository.deleteById(id);}
    public void updatechattRoom(long id, ChattRoom chattRoom) {
        jpaChattRoomRepository.save(chattRoom);
    }
}

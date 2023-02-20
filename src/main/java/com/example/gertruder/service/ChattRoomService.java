package com.example.gertruder.service;

import com.example.gertruder.model.ChattRoom;
import com.example.gertruder.repository.JpaChattRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChattRoomService {

    @Autowired
    private JpaChattRoomRepository jpaChattRoomRepository;

    public List <ChattRoom> getChattRoom() {return jpaChattRoomRepository.findAll();}
    public ChattRoom addChattRoom(ChattRoom chattRoom) {return jpaChattRoomRepository.save(chattRoom);
    }
    public ChattRoom get(long id) {return jpaChattRoomRepository.getReferenceById(id);}

    public ChattRoom save(ChattRoom chattRoom) {return jpaChattRoomRepository.save(chattRoom);}
    public void delete(long id){jpaChattRoomRepository.deleteById(id);}


}

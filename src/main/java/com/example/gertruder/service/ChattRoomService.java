package com.example.gertruder.service;

import com.example.gertruder.model.ChattRoom;
import com.example.gertruder.repository.JpaChattRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChattRoomService {

    @Autowired
    private JpaChattRoomRepository chattRoomRepository;

    public List <ChattRoom> getAll() {return chattRoomRepository.findAll();}

    public ChattRoom get(long id) {return chattRoomRepository.getReferenceById(id);}

    public ChattRoom save(ChattRoom chattRoom) {return chattRoomRepository.save(chattRoom);}
    public void delete(long chattRoomId){chattRoomRepository.deleteById(chattRoomId);}
}

package com.example.gertruder.controller;

import com.example.gertruder.model.ChattRoom;
import com.example.gertruder.service.ChattRoomService;
import com.example.gertruder.ws.ChattRoomStateSocketHandler;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Data
@RequestMapping("/chattRoom/")
public class ChattRoomController {
    
    @Autowired
    private ChattRoomStateSocketHandler chattRoomStateSocketHandler;
    @Autowired
    private ChattRoomService chattRoomService;


    @GetMapping
    public ResponseEntity<List<ChattRoom>> getChattRoom() {
        return ResponseEntity.ok(chattRoomService.getChattRoom());
    }
   
    @RequestMapping(method = RequestMethod.POST, value = "/chattRoom")
    private void addChattRoom(@RequestBody ChattRoom chattRoom) {
        chattRoomService.addChattRoom(chattRoom);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/chattRooms/{id}")
    private void updateChattRoom(@RequestBody ChattRoom chattRoom, @PathVariable long id) {
        chattRoomService.updatechattRoom(id, chattRoom);
    }

    @PostMapping
    public ResponseEntity<ChattRoom> createChattRoom(@RequestBody ChattRoom chattRoom) {
        ChattRoom createChattRoom = chattRoomService.save(chattRoom);
        chattRoomStateSocketHandler.broadcast(createChattRoom);
        return ResponseEntity.status(201).body(createChattRoom);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<List<ChattRoom>> deleteChattRoom(@PathVariable long id){
        chattRoomService.delete(id);
        return getChattRoom();
    }
    



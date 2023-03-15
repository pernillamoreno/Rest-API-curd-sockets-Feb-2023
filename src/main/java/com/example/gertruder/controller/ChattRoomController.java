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
@RequestMapping("/chattRooms/")
public class ChattRoomController {
    
    @Autowired
    private ChattRoomStateSocketHandler chattRoomStateSocketHandler;
    @Autowired
    private ChattRoomService chattRoomService;
    private List<ChattRoom> chattRoomList;


    @GetMapping
    public ResponseEntity<List<ChattRoom>> getChattRoom() {
        return ResponseEntity.ok(chattRoomService.getChattRooms());
    }
   
    @RequestMapping(method = RequestMethod.PUT, value = "/chattRooms/{id}")
    private void updateChattRoom(@RequestBody ChattRoom chattRoom, @PathVariable long id) {
        chattRoomService.updatechattRoom(id, chattRoom);
    }

    @PostMapping
    public ResponseEntity<ChattRoom> createChattRoom(@RequestBody ChattRoom chattRoom){
        ChattRoom createdChattRoom = chattRoomService.save(chattRoom);
        chattRoomStateSocketHandler.broadcast(createdChattRoom);
        return ResponseEntity.status(201).body(createdChattRoom);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<List<ChattRoom>> deleteChattRoom(@PathVariable long id){
        chattRoomService.delete(id);
        return getChattRoom();
    }
    
}

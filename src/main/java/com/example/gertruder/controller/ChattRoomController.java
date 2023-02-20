package com.example.gertruder.controller;

import com.example.gertruder.model.ChattRoom;
import com.example.gertruder.service.ChattRoomService;
import com.example.gertruder.ws.ChattRoomStateSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ChattRoomController { // CHANGES COMING UP SOOOON!!
    @Autowired
    private ChattRoomStateSocketHandler chattRoomStateSocketHandler;
    @Autowired
    private ChattRoomService chattRoomService;


    @GetMapping
    public ResponseEntity<List<ChattRoom>> getChattRoom() {
        return ResponseEntity.ok(chattRoomService.getChattRoom());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<List<ChattRoom>> deleteChattRoom(@PathVariable long id){
        chattRoomService.delete(id);
        return getChattRoom();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/chattRoom")
    private void addChattRoom(@RequestBody ChattRoom chattRoom) {
        chattRoomService.addChattRoom(chattRoom);
    }



    @PostMapping
    public ResponseEntity<ChattRoom> createChattRoom(@RequestBody ChattRoom chattRoom) {      
        

        ChattRoom createChattRoom = chattRoomService.save(chattRoom);
        chattRoomStateSocketHandler.broadcast(createChattRoom);
        return ResponseEntity.status(204).body(createChattRoom);
    }

}


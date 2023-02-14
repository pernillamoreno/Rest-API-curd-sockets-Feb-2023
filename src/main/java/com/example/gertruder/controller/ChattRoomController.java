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
    private ChattRoomStateSocketHandler chattRoomSocketHandler;
    @Autowired
    private ChattRoomService chattRoomService;


    @GetMapping("/")
    public ChattRoom getChattroom(){
        ChattRoom chattRoom = new ChattRoom();
        chattRoom.setId(1);
        chattRoom.setTitel("hej");
        chattRoom.setAttendeees("");
        return chattRoom;
    }

    @RequestMapping("/")
    public List<ChattRoom>ChattRooms() {
       List<ChattRoom> chattRooms = new ArrayList<>();

        chattRooms.add(new ChattRoom(1,"bääää","många",true));
        chattRooms.add(new ChattRoom(2,"bä","bö",false));
        return chattRooms;


        //return ResponseEntity.ok(chattRoomService.getAll());
    }


   @GetMapping
    public ResponseEntity<ChattRoom> getStudentById(@PathVariable long chattRoomId) {
        return ResponseEntity.ok(chattRoomService.get(chattRoomId));
    }



   /* @PostMapping("student")
    @PatchMapping("student")
    @PutMapping("student")
    public ResponseEntity<List<Student>> addStudent(@RequestBody Student student) {
        studentService.save(student);
        studentStateSocketHandler.broadcast(student.getName() + " was created");
        return getAllStudents();
    }

    @DeleteMapping("student")
    public ResponseEntity<List<Student>> deleteStudent(@RequestBody Student student) {
        studentService.delete(student.getId());
        return getAllStudents();
    }

    @DeleteMapping("student/{studentId}")
    public ResponseEntity<List<Student>> deleteStudent(@PathVariable long studentId) {
        studentService.delete(studentId);
        return getAllStudents();
    }

    @PatchMapping("student/online/{state}/{studentId}")
    public void setOnlineState(@PathVariable String state, @PathVariable long studentId) {
        Student newStudent = studentService.get(studentId);
        Student oldStudent = newStudent.clone();

        switch(state) {
            case "online": newStudent.setOnline(true); break;
            case "offline": newStudent.setOnline(false); break;
            default: throw new IllegalStateException(state + " was illdefined");
        }


        studentService.save(newStudent);

        // broadcast student changes
        studentStateSocketHandler.broadcast(oldStudent, newStudent);*/
    }



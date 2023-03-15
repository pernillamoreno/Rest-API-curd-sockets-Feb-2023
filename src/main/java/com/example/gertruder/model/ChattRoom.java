package com.example.gertruder.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class ChattRoom {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String title;
}




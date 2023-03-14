package com.example.gertruder.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Data
public class ChattRoom {
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTO_INCREMENT

    @Id //primary key

    private long id;
    private String titel;
  
}



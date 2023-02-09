package com.example.gertruder.repository;

import com.example.gertruder.model.ChattRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaChattRoomRepository extends JpaRepository<ChattRoom, Long> {
}

package com.example.gertruder.repository;

import com.example.gertruder.model.ChattRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository//("chattRoomRepository")
public interface JpaChattRoomRepository extends JpaRepository<ChattRoom, Long> {


}

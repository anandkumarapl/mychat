package com.example.mychat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatBoxRepository extends JpaRepository<ChatBox,Integer> {
}

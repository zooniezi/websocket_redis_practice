package com.example.demo.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "chatroom")
public class ChatRoom {
    @Id
    private String id;
    private String name;
    private List<String> participants;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

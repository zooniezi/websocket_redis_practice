package com.example.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chatmessage")
public class ChatMessage {
    @Id
    private String id;
    private String chatroomId;
    private String senderId;
    private String message;
    private LocalDateTime sendAt;
    private boolean isRead;
}

package com.example.demo.controller;

import com.example.demo.pubsub.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final RedisPublisher redisPublisher;

    @MessageMapping("/sendMessage")
    public void sendMessage(@Payload String message) {
        // Redis 채널로 메시지 발행
        redisPublisher.publish(message);
        System.out.println("Message Sent to Redis: " + message);
    }
}

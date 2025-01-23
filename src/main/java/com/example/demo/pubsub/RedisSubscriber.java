package com.example.demo.pubsub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisSubscriber {

    private final SimpMessagingTemplate messagingTemplate;

    public void handleMessage(String message) {
        log.info("Redis에서 받은 메시지: {}", message);
        // 받은 메시지를 WebSocket 구독자들에게 전송
        messagingTemplate.convertAndSend("/sub/messages", message);
    }
}
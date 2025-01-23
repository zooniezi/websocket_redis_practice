package com.example.demo.pubsub;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPublisher {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;

    public void publish(String message) {
        // 메시지를 Redis 채널로 발행
        redisTemplate.convertAndSend(topic.getTopic(), message);
        System.out.println("Message Published: " + message);
    }
}

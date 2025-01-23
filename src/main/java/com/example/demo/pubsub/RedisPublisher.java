package com.example.demo.pubsub;


import com.example.demo.domain.ChatMessage;
import com.example.demo.repository.ChatMessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisPublisher {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;
    private final ObjectMapper objectMapper;
    private final ChatMessageRepository chatMessageRepository;

    public void publish(ChatMessage message) {
        try {
            // mongoDB에 메세지 저장하기
            chatMessageRepository.save(message);
            log.info("Message saved successfully");

            // redis pub/sub로 발행하기
            String messageJson = objectMapper.writeValueAsString(message);
            redisTemplate.convertAndSend(topic.getTopic(), messageJson);
            log.info("Redis로 메시지 발행: {}", messageJson);
        } catch (JsonProcessingException e) {
            log.error("Redis 메시지 발행 실패", e);
        }
    }
}

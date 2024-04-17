package com.example.management.kafka;

import com.example.management.dto.request.BuyRollbackKfkDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, BuyRollbackKfkDto> kafkaTemplate;

    public void sendMessage(BuyRollbackKfkDto dto) {
        String TOPIC_NAME = "buy_rollback";
        kafkaTemplate.send(TOPIC_NAME, dto);
        System.out.println("Sent Rollback Event: " + dto);

    }
}

package com.example.paypoint.kafka;

import com.example.paypoint.dto.request.BuyRollbackReqDto;
import com.example.paypoint.dto.response.BuyRollbackKfkDto;
import com.example.paypoint.service.PaypointService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ObjectMapper objectMapper;
    private final PaypointService paypointService;

    @KafkaListener(topics = "buy_rollback", groupId = "my-group")
    public void listen(String message) {
        log.info("buy rollback - Call");
        System.out.println("message : " + message);
        BuyRollbackKfkDto dto = null;
        try {
            dto = objectMapper.readValue(message, BuyRollbackKfkDto.class); //dto로 변환

            paypointService.buyRollback(BuyRollbackReqDto.builder() //서비스 실행
                    .memberId(dto.getMemberId())
                    .payLogId(dto.getPayLogId())
                    .build());

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Received dto: " + dto);
    }
}
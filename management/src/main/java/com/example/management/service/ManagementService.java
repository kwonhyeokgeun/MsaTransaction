package com.example.management.service;

import com.example.management.client.PaypointServiceClient;
import com.example.management.dto.request.BuyReqDto;
import com.example.management.dto.request.EatReqDto;
import com.example.management.dto.response.BuyResDto;
import com.example.management.dto.response.EatResDto;
import com.example.management.entity.Entity;
import com.example.management.exception.ManagementException;
import com.example.management.exception.PaypointException;
import com.example.management.global.CustomBody;
import com.example.management.repository.ManagementRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagementService {
    private final ManagementRepository managementRepository;
    private final PaypointServiceClient paypointServiceClient;
    private final ObjectMapper objectMapper;

    public EatResDto eat(EatReqDto reqDto) throws PaypointException, ManagementException {
        ResponseEntity<CustomBody> responseEntity = paypointServiceClient.buy(BuyReqDto.builder()
                .memberId(reqDto.getMemberId())
                .code(reqDto.getCode())
                .mount(reqDto.getMount())
                .build()
            );
        if(responseEntity.getStatusCode() != HttpStatus.OK)
            throw new PaypointException("");
        Object data =  responseEntity.getBody().getData();
        BuyResDto buyResDto = objectMapper.convertValue(data, BuyResDto.class);
        System.out.println(buyResDto);

        Long payLogId= buyResDto.getPayLogId();
        Optional.ofNullable(managementRepository.eat())
                .orElseThrow(()->new ManagementException(payLogId, ""));


        return EatResDto.builder()
                .build();
    }
}

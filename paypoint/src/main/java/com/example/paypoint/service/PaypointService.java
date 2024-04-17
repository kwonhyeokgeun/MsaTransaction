package com.example.paypoint.service;

import com.example.paypoint.dto.request.BuyReqDto;
import com.example.paypoint.dto.request.BuyRollbackReqDto;
import com.example.paypoint.dto.response.BuyResDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaypointService {
    public Integer paypoint=1000;
    public Long payLogId=0L;
    public Map<Long,Integer> payLog = new HashMap<>();

    public BuyResDto buy(BuyReqDto reqDto){
        paypoint-=reqDto.getMount();
        payLog.put(payLogId,reqDto.getMount());
        System.out.println("구매처리");
        System.out.println("paypoint : " + paypoint);
        System.out.println("log : " + payLog);
        return BuyResDto.builder()
            .payLogId(payLogId++)
            .paypoint(paypoint)
            .build();
    }

    public BuyResDto buyRollback(BuyRollbackReqDto reqDto){
        Integer mount = payLog.get(reqDto.getPayLogId());
        payLog.remove(reqDto.getPayLogId());
        paypoint += mount;
        System.out.println("롤백처리");
        System.out.println("paypoint : " + paypoint);
        System.out.println("log : " + payLog);
        return null;
    }




}

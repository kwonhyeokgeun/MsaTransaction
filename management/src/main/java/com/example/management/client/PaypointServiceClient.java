package com.example.management.client;


import com.example.management.dto.request.BuyReqDto;
import com.example.management.global.CustomBody;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paypoint")
public interface PaypointServiceClient {
    @PostMapping("/paypoint/buy")
    ResponseEntity<CustomBody> buy(@RequestBody BuyReqDto reqDto);
}

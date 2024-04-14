package com.example.paypoint.controller;

import com.example.paypoint.dto.request.BuyReqDto;
import com.example.paypoint.dto.response.BuyResDto;
import com.example.paypoint.global.CustomBody;
import com.example.paypoint.global.ResMsg;
import com.example.paypoint.global.StatusEnum;
import com.example.paypoint.service.PaypointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paypoint")
public class PaypointController {
    private final PaypointService paypointService;
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the paypoint service.";
    }

    @PostMapping("/buy")
    public ResponseEntity<CustomBody> buy(@RequestBody BuyReqDto reqDto) {
        BuyResDto resDto = paypointService.buy(reqDto);
        return ResponseEntity.ok(new CustomBody(StatusEnum.OK, ResMsg.SUCCESS, resDto));
    }

}
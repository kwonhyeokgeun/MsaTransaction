package com.example.management.controller;

import com.example.management.client.PaypointServiceClient;
import com.example.management.dto.request.BuyReqDto;
import com.example.management.dto.request.BuyRollbackReqDto;
import com.example.management.dto.request.EatReqDto;
import com.example.management.dto.response.EatResDto;
import com.example.management.exception.ManagementException;
import com.example.management.exception.PaypointException;
import com.example.management.global.CustomBody;
import com.example.management.global.ResMsg;
import com.example.management.global.StatusEnum;
import com.example.management.service.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management")
public class ManagementController {

    private final ManagementService managementService;

    @GetMapping("/welcome")
    public String welcome() {

        return "Welcome to the management service.";
    }

    @PostMapping("/eat")
    public ResponseEntity<CustomBody> eat(@RequestBody EatReqDto reqDto) {

        try{
            EatResDto resDto = managementService.eat(reqDto);
            return ResponseEntity.ok(new CustomBody(StatusEnum.OK, ResMsg.SUCCESS, resDto));
        }catch (PaypointException e){
            return ResponseEntity.ok(new CustomBody(StatusEnum.OK, ResMsg.INTERNAL_SERVER_ERROR, null));
        }catch (ManagementException e){
            Long payLogId = e.payLogId;
            return ResponseEntity.ok(new CustomBody(StatusEnum.OK, ResMsg.INTERNAL_SERVER_ERROR, null));
        }


    }
}

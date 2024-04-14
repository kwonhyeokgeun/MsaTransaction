package com.example.paypoint.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyReqDto {
    Long memberId;
    Integer mount;
    String code;
}

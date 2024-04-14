package com.example.management.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EatReqDto {
    Long memberId;
    Integer mount;
    String code;
}

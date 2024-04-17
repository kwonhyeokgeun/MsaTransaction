package com.example.management.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyRollbackKfkDto {
    @JsonProperty("memberId")
    private Long memberId;
    @JsonProperty("payLogId")
    private Long payLogId;
}

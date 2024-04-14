package com.example.management.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ManagementException extends Exception{
    public Long payLogId;
    public ManagementException(Long payLogId, String msg){
        super(msg);
        this.payLogId = payLogId;
    }
}

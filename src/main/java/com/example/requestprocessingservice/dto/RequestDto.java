package com.example.requestprocessingservice.dto;

import lombok.Data;

@Data
public class RequestDto {
    private Long id;
    private String text;
    private Long modifiedDate;
    private Long length;
}

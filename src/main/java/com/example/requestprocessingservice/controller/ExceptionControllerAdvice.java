package com.example.requestprocessingservice.controller;

import com.example.requestprocessingservice.dto.ExceptionDto;
import com.example.requestprocessingservice.error.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleEntityException(EntityNotFoundException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMassage(ex.getResponseCode().getMessage());
        return new  ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}

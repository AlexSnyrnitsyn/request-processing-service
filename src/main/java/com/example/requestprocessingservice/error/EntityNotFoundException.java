package com.example.requestprocessingservice.error;

import com.example.requestprocessingservice.enums.ResponseCode;

public class EntityNotFoundException extends RuntimeException {

    private ResponseCode responseCode;

    public EntityNotFoundException(ResponseCode responseCode){
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode(){
        return responseCode;
    }

}

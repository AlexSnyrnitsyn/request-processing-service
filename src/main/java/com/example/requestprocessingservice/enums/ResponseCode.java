package com.example.requestprocessingservice.enums;

public enum ResponseCode {

    REQUEST_NOT_FOUND("Request not found"),
    TAG_NOT_FOUND("Tag not found"),
    FOLDER_NOT_FOUND("Folder not found"),
    REQUEST_GAT_LINK_ERROR("Forbidden link request with more than 10 tags");

    private String message;

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}

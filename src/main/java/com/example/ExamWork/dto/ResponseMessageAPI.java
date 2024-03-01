package com.example.ExamWork.dto;

import com.example.ExamWork.enums.ResultCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseMessageAPI <T> {
        T result;
        String resultCode;
        String details;
        String message;
        int code;

    public ResponseMessageAPI(T result, String resultCode, String details, String message, int code) {
        this.result = result;
        this.resultCode = resultCode;
        this.details = details;
        this.message = message;
        this.code = code;
    }
}

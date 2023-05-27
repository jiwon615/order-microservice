package com.jimart.orderservice.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum ErrorMsgType {

    // common
    COMMON_SERVER_ERROR(INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다."),

    // order
    ORD_NOT_FOUND(NOT_FOUND, "해당 주문 내역이 없습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}

package com.jimart.orderservice.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorMsgType {

    // common
    COMMON_SERVER_ERROR(INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다."),
    COMMON_ERROR_400(BAD_REQUEST, "잘못된 요청입니다."),
    COMMON_ERROR_404(NOT_FOUND, "해당 정보를 찾지 못했습니다."),

    // order
    ORD_NOT_FOUND(NOT_FOUND, "해당 주문 내역이 없습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}

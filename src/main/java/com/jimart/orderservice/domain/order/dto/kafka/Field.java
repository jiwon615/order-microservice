package com.jimart.orderservice.domain.order.dto.kafka;

import lombok.*;

// 데이터를 저장하기 위해 어떤 필드를 저장할지 지정
@Getter
@NoArgsConstructor
public class Field {

    private String type;
    private boolean optional;
    private String field;

    @Builder
    private Field(String type, boolean optional, String field) {
        this.type = type;
        this.optional = optional;
        this.field = field;
    }
}

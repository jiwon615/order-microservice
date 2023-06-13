package com.jimart.orderservice.domain.order.dto.kafka;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Builder
public class Schema {

    private String type;
    private List<Field> fields;
    private boolean optional;
    private String name;
}

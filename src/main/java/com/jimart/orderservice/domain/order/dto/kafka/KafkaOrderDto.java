package com.jimart.orderservice.domain.order.dto.kafka;

import lombok.Getter;

@Getter
public class KafkaOrderDto {

    private Schema schema;
    private Payload payload;
}

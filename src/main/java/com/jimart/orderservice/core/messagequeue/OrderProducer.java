package com.jimart.orderservice.core.messagequeue;

import com.jimart.orderservice.domain.order.dto.kafka.Field;
import com.jimart.orderservice.domain.order.dto.kafka.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void test() {

    }
}

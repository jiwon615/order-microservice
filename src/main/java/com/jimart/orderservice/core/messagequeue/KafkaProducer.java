package com.jimart.orderservice.core.messagequeue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, List<Long> productIds) {
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonInString = "";
//        try {
//            jsonInString = mapper.registerModule(new JavaTimeModule()).writeValueAsString(productIds);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        kafkaTemplate.send(topic, StringUtils.join(productIds, ","));
        log.info(">> Kafka Producer sent data from Order microservice: {}", productIds);
    }
}

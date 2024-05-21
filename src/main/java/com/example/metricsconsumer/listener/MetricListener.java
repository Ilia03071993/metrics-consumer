package com.example.metricsconsumer.listener;

import com.example.metricsconsumer.dto.MetricDto;
import com.example.metricsconsumer.service.MetricService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class MetricListener {
    private final MetricService metricService;
    private final ObjectMapper mapper;

    @KafkaListener(topics = "metrics-topic")
    public void listenMetrics(String message) {
        log.info(message);
        try {
            MetricDto metric = mapper.readValue(message, MetricDto.class);
            metricService.saveMetric(metric);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
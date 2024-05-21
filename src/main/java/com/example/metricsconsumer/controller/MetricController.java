package com.example.metricsconsumer.controller;

import com.example.metricsconsumer.dto.MetricDto;
import com.example.metricsconsumer.service.MetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MetricController {
    private final MetricService metricService;

    @GetMapping("/api/metrics")
    public List<MetricDto> getMetrics() {
        return metricService.getMetrics();
    }

    @GetMapping("/api/metrics/{id}")
    public MetricDto getMetric(@PathVariable UUID id) {
        return metricService.getMetricByUUID(id);
    }
}

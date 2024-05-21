package com.example.metricsconsumer.service;

import com.example.metricsconsumer.dto.MetricDto;
import com.example.metricsconsumer.mapper.MetricMapper;
import com.example.metricsconsumer.repository.MetricRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class MetricService {
    private final MetricRepository metricRepository;
    private final MetricMapper mapper;

    public void saveMetric(MetricDto metricDto) {
        metricRepository.save(mapper.toEntity(metricDto));
    }

    public MetricDto getMetricByUUID(UUID id) {
      return mapper.toDto(metricRepository.findById(id).orElseThrow());
    }

    public List<MetricDto> getMetrics(){
        return metricRepository.findAll().stream()
                .map(mapper::toDto).toList();
    }
}
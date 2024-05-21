package com.example.metricsconsumer.mapper;

import com.example.metricsconsumer.dto.MetricDto;
import com.example.metricsconsumer.entity.Metric;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetricMapper {
    MetricDto toDto (Metric metric);
    Metric toEntity (MetricDto metricDto);
}

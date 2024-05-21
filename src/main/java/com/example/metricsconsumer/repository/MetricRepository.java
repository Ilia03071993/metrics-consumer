package com.example.metricsconsumer.repository;

import com.example.metricsconsumer.entity.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MetricRepository extends JpaRepository<Metric, UUID> {
}

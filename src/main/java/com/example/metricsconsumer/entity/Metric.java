package com.example.metricsconsumer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "metrics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Metric {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "type")
    private String type;

    @Column(name = "message")
    private String message;

}
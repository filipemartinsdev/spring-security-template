package com.spring.app.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity @Table(name = "product")
@AllArgsConstructor @NoArgsConstructor @Data
public class Product {
    @Id
    private UUID id;

    private String name;

    private BigDecimal price;
}

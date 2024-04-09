package com.erp.erp_backend.quality.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
public class CardNP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long lot;
    @Column(name = "defective_items_sample")
    private Long defectiveItemsSample;
    @Column(name = "user_id")
    private Long userId;
}

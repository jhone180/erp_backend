package com.erp.erp_backend.quality.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@Entity
public class CardC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long month;
    private Long intoxicated;
    @Column(name = "user_id")
    private Long userId;
}

package com.erp.erp_backend.quality.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@Entity
@Table(name = "card_xrm")
public class CardXRM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hours;
    private Long sample;
    @Column(name = "user_id")
    private Long userId;
}

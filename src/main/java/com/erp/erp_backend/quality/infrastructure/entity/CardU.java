package com.erp.erp_backend.quality.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@Entity
@Table(name = "card_u")
public class CardU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long lot;
    @Column(name = "sample_size")
    private Long sampleSize;
    @Column(name = "totally_defective")
    private Long totallyDefective;
    @Column(name = "average_number_defects_circuit")
    private Long averageNumberDefectsCircuit;
    @Column(name = "user_id")
    private Long userId;
}

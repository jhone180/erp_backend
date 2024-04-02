package com.erp.erp_backend.quality.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Builder
@Value
@Entity
@Getter
@Setter
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
}

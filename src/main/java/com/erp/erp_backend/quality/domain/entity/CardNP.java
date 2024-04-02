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
public class CardNP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long lot;
    @Column(name = "defective_items_sample")
    private Long defectiveItemsSample;
}

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
public class CardP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sample;
    @Column(name = "lot_size")
    private Long lotSize;
    @Column(name = "defective_items")
    private Long defectiveItems;
}

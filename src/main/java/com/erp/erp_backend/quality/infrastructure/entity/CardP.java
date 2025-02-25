package com.erp.erp_backend.quality.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "card_p")
public class CardP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sample;
    @Column(name = "lot_size")
    private Long lotSize;
    @Column(name = "defective_items")
    private Long defectiveItems;
    private Double proportion;
    @Column(name = "user_id")
    private Long userId;
}

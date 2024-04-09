package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.usercase.GetCardCComponent;
import com.erp.erp_backend.quality.infrastructure.entity.CardC;

public class GetCardCComponentImpl implements GetCardCComponent {

    @Override
    public CardC get() {
        return CardC.builder()
                .id(1L)
                .month(1L)
                .intoxicated(1L)
                .build();
    }
}

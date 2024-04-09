package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.infrastructure.port.repository.CardNPRepository;

public class CardNPRepositoryImpl {
    CardNPRepository cardNPRepository;

    public CardNPRepositoryImpl(CardNPRepository cardNPRepository){
        this.cardNPRepository = cardNPRepository;
    }
}

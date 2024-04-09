package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.infrastructure.port.repository.CardPRepository;

public class CardPRepositoryImpl {
    CardPRepository cardPRepository;

    public CardPRepositoryImpl(CardPRepository cardPRepository){
        this.cardPRepository = cardPRepository;
    }
}

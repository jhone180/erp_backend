package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardXRRepository;

public class CardXRRepositoryImpl {

    CardXRRepository cardXRRepository;

    public CardXRRepositoryImpl(CardXRRepository cardXRRepository){
        this.cardXRRepository = cardXRRepository;
    }

    public CardXR findById(){
        return null;
    }
}

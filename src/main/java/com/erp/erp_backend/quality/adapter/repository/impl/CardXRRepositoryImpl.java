package com.erp.erp_backend.quality.adapter.repository.impl;

import com.erp.erp_backend.quality.domain.entity.CardXR;
import com.erp.erp_backend.quality.port.repository.CardXRRepository;

public class CardXRRepositoryImpl {

    CardXRRepository cardXRRepository;

    public CardXRRepositoryImpl(CardXRRepository cardXRRepository){
        this.cardXRRepository = cardXRRepository;
    }

    public CardXR findById(){
        return null;
    }
}

package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRMRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardXRMRepository;

import java.util.Optional;

public class CardXRMRepositoryLogicImpl implements CardXRMRepositoryLogic {
    CardXRMRepository cardXRMRepository;

    public CardXRMRepositoryLogicImpl(CardXRMRepository cardXRMRepository){
        this.cardXRMRepository = cardXRMRepository;
    }

    @Override
    public void save(Optional<CardXRM> cardXRM) {
        cardXRM.ifPresentOrElse(
                cardXRM1 -> cardXRMRepository.save(cardXRM1),
                () -> { throw new RuntimeException("The object CardXRM cannot be null"); }
        );
    }

    @Override
    public CardXRM findByUserId(Long userId) {
        return null;
    }

    @Override
    public CardXRM modify() {
        return null;
    }
}

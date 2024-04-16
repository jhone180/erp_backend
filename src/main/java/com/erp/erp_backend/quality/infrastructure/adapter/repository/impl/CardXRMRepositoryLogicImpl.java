package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.exception.exceptions.ObjectNullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRMRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardXRMRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CardXRMRepositoryLogicImpl implements CardXRMRepositoryLogic {
    CardXRMRepository cardXRMRepository;

    public CardXRMRepositoryLogicImpl(CardXRMRepository cardXRMRepository){
        this.cardXRMRepository = cardXRMRepository;
    }

    @Override
    public CardXRM findByUserId(Long userId) {
        return null;
    }

    @Override
    public CardXRM create(CardXRM entity) {
        return null;
    }

    @Override
    public boolean createAll(Optional<List<CardXRM>> cardXRM) {
        cardXRM.ifPresentOrElse(
                cardXRM1 -> cardXRMRepository.saveAll(cardXRM1),
                () -> { throw new ObjectNullException(cardXRM); }
        );
        return true;
    }

    @Override
    public boolean update(Optional<CardXRM> entity) {
        entity.ifPresentOrElse(
                cardXRM1 -> cardXRMRepository.save(cardXRM1),
                () -> { throw new ObjectNullException(entity); }
        );
        return true;
    }

    @Override
    public Optional<CardXRM> read(Long aLong) {
        return cardXRMRepository.findById(aLong);
    }

    @Override
    public void delete(Long aLong) {

    }
}

package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.exception.exceptions.ObjectNullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardXRRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CardXRRepositoryLogicImpl implements CardXRRepositoryLogic {
    CardXRRepository cardXRRepository;

    public CardXRRepositoryLogicImpl(CardXRRepository cardXRRepository){
        this.cardXRRepository = cardXRRepository;
    }

    @Override
    public CardXRM findByUserId(Long userId) {
        return null;
    }

    @Override
    public CardXR create(CardXR entity) {
        return null;
    }

    @Override
    public boolean createAll(Optional<List<CardXR>> cardXR) {
        cardXR.ifPresentOrElse(
                cardXR1 -> cardXRRepository.saveAll(cardXR1),
                () -> { throw new ObjectNullException(cardXR); }
        );
        return true;
    }

    @Override
    public boolean update(Optional<CardXR> entity) {
        entity.ifPresentOrElse(
                cardXR1 -> cardXRRepository.save(cardXR1),
                () -> { throw new ObjectNullException(entity); }
        );
        return true;
    }

    @Override
    public Optional<CardXR> read(Long aLong) {
        return cardXRRepository.findById(aLong);
    }

    @Override
    public void delete(Long aLong) {

    }
}

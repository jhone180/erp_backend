package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.exception.exceptions.ObjectNullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardPRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardP;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardPRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CardPRepositoryLogicImpl implements CardPRepositoryLogic {

    CardPRepository cardPRepository;

    public CardPRepositoryLogicImpl(CardPRepository cardPRepository){
        this.cardPRepository = cardPRepository;
    }

    @Override
    public CardP create(CardP entity) {
        return null;
    }

    @Override
    public boolean createAll(Optional<List<CardP>> entities) {
        entities.ifPresentOrElse(
                cardP -> cardPRepository.saveAll(cardP),
                () -> { throw new ObjectNullException(entities); }
        );
        return true;
    }

    @Override
    public Optional<CardP> read(Long aLong) {
        return cardPRepository.findById(aLong);
    }

    @Override
    public boolean update(Optional<CardP> entity) {
        entity.ifPresentOrElse(
                cardP -> cardPRepository.save(cardP),
                () -> { throw new ObjectNullException(entity); }
        );
        return true;
    }

    @Override
    public void delete(Long aLong) {
        cardPRepository.deleteByUserId(aLong);
    }

    @Override
    public List<CardP> findByUserId(Long userId) {
        return cardPRepository.findByUserId(userId);
    }
}

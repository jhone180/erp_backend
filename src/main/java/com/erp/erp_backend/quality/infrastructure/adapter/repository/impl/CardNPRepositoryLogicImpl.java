package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.exception.exceptions.ObjectNullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardNPRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardNP;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardNPRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CardNPRepositoryLogicImpl implements CardNPRepositoryLogic {

    CardNPRepository cardNPRepository;

    public CardNPRepositoryLogicImpl(CardNPRepository cardNPRepository){
        this.cardNPRepository = cardNPRepository;
    }

    @Override
    public CardNP create(CardNP entity) {
        return null;
    }

    @Override
    public boolean createAll(Optional<List<CardNP>> entities) {
        entities.ifPresentOrElse(
                cardNP -> cardNPRepository.saveAll(cardNP),
                () -> { throw new ObjectNullException(entities); }
        );
        return true;
    }

    @Override
    public Optional<CardNP> read(Long aLong) {
        return cardNPRepository.findById(aLong);
    }

    @Override
    public boolean update(Optional<CardNP> entity) {
        entity.ifPresentOrElse(
                cardNP -> cardNPRepository.save(cardNP),
                () -> { throw new ObjectNullException(entity); }
        );
        return true;
    }

    @Override
    public void delete(Long aLong) {

    }
}

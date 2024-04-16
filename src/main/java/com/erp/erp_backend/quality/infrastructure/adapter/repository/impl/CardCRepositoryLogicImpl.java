package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.exception.exceptions.ObjectNullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardCRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardC;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardCRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardCRepositoryLogicImpl implements CardCRepositoryLogic {

    CardCRepository cardCRepository;

    public CardCRepositoryLogicImpl(CardCRepository cardXRMRepository){
        this.cardCRepository = cardXRMRepository;
    }

    @Override
    public CardC create(CardC entity) {
        return null;
    }

    @Transactional
    @Override
    public boolean createAll(Optional<List<CardC>> entities) {
        entities.ifPresentOrElse(
                cardC -> cardCRepository.saveAll(cardC),
                () -> { throw new ObjectNullException(entities); }
        );
        return true;
    }

    @Override
    public Optional<CardC> read(Long aLong) {
        return cardCRepository.findById(aLong);
    }

    @Transactional
    @Override
    public boolean update(Optional<CardC> entity) {
        entity.ifPresentOrElse(
                cardXRM1 -> cardCRepository.save(cardXRM1),
                () -> { throw new ObjectNullException(entity); }
        );
        return true;
    }

    @Override
    public void delete(Long aLong) {

    }
}

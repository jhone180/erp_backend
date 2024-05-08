package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.exception.exceptions.ObjectNullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardURepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardU;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardURepository;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardXRRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardURepositoryLogicImpl implements CardURepositoryLogic {

    CardURepository cardURepository;

    public CardURepositoryLogicImpl(CardURepository cardURepository, CardXRRepository cardXRRepository){
        this.cardURepository = cardURepository;
    }

    @Override
    public CardU create(CardU entity) {
        return null;
    }

    @Transactional
    @Override
    public boolean createAll(Optional<List<CardU>> entities) {
        entities.ifPresentOrElse(
                cardU -> cardURepository.saveAll(cardU),
                () -> { throw new ObjectNullException(entities); }
        );
        return true;
    }

    @Override
    public Optional<CardU> read(Long aLong) {
        return cardURepository.findById(aLong);
    }

    @Override
    public boolean update(Optional<CardU> entity) {
        entity.ifPresentOrElse(
                cardU -> cardURepository.save(cardU),
                () -> { throw new ObjectNullException(entity); }
        );
        return true;
    }

    @Override
    public void delete(Long aLong) {
        cardURepository.deleteByUserId(aLong);
    }

    @Override
    public List<CardU> findByUserId(Long userId) {
        return cardURepository.findByUserId(userId);
    }
}

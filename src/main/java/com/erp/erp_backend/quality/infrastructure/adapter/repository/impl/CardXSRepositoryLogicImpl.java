package com.erp.erp_backend.quality.infrastructure.adapter.repository.impl;

import com.erp.erp_backend.quality.exception.exceptions.ObjectNullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXSRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXS;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardXSRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CardXSRepositoryLogicImpl implements CardXSRepositoryLogic {
    CardXSRepository cardXSRepository;

    public CardXSRepositoryLogicImpl(CardXSRepository cardXSRepository){
        this.cardXSRepository = cardXSRepository;
    }

    @Override
    public CardXS findByUserId(Long userId) {
        return null;
    }

    @Override
    public CardXS create(CardXS entity) {
        return null;
    }

    @Override
    public boolean createAll(Optional<List<CardXS>> cardXS) {
        cardXS.ifPresentOrElse(
                cardXR1 -> cardXSRepository.saveAll(cardXR1),
                () -> { throw new ObjectNullException(cardXS); }
        );
        return true;
    }

    @Override
    public boolean update(Optional<CardXS> entity) {
        entity.ifPresentOrElse(
                cardXS1 -> cardXSRepository.save(cardXS1),
                () -> { throw new ObjectNullException(entity); }
        );
        return true;
    }

    @Override
    public Optional<CardXS> read(Long aLong) {
        return cardXSRepository.findById(aLong);
    }

    @Override
    public void delete(Long aLong) {

    }
}

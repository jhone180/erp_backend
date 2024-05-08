package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.usercase.GetCardPComponent;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardPRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardP;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetCardPComponentImpl implements GetCardPComponent {

    CardPRepositoryLogic cardPRepositoryLogic;

    public GetCardPComponentImpl(CardPRepositoryLogic cardPRepositoryLogic) {
        this.cardPRepositoryLogic = cardPRepositoryLogic;
    }

    @Override
    public List<CardP> apply(Long aLong) {
        if (aLong == null)
            throw new NullException("Id cannot be null");
        return cardPRepositoryLogic.findByUserId(aLong);
    }
}

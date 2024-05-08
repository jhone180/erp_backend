package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.usercase.GetCardCComponent;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardCRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardC;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetCardCComponentImpl implements GetCardCComponent {

    CardCRepositoryLogic cardCRepositoryLogic;

    public GetCardCComponentImpl(CardCRepositoryLogic cardCRepositoryLogic) {
        this.cardCRepositoryLogic = cardCRepositoryLogic;
    }

    @Override
    public List<CardC> apply(Long aLong) {
        if (aLong == null)
            throw new NullException("User id is required");
        return cardCRepositoryLogic.findByUserId(aLong);
    }
}

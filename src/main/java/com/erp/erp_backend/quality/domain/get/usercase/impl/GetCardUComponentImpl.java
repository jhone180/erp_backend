package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.usercase.GetCardUComponent;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardURepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardU;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetCardUComponentImpl implements GetCardUComponent {

    CardURepositoryLogic cardURepositoryLogic;

    public GetCardUComponentImpl(CardURepositoryLogic cardURepositoryLogic) {
        this.cardURepositoryLogic = cardURepositoryLogic;
    }

    @Override
    public List<CardU> apply(Long aLong) {
        return cardURepositoryLogic.findByUserId(aLong);
    }
}

package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.usercase.GetCardNPComponent;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardNPRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardNP;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetCardNPComponentImpl implements GetCardNPComponent {

    CardNPRepositoryLogic cardNPRepositoryLogic;

    public GetCardNPComponentImpl(CardNPRepositoryLogic cardNPRepositoryLogic) {
        this.cardNPRepositoryLogic = cardNPRepositoryLogic;
    }

    @Override
    public List<CardNP> apply(Long aLong) {
        if (aLong == null)
            throw new NullException("Card Id is null");
        return cardNPRepositoryLogic.findByUserId(aLong);
    }
}

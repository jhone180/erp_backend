package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.usercase.GetCardXRMComponent;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRMRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetCardXRMComponentImpl implements GetCardXRMComponent {

    CardXRMRepositoryLogic cardXRMRepositoryLogic;

    public GetCardXRMComponentImpl(CardXRMRepositoryLogic cardXRMRepositoryLogic) {
        this.cardXRMRepositoryLogic = cardXRMRepositoryLogic;
    }

    @Override
    public List<CardXRM> apply(Long aLong) {
        if (aLong == null)
            throw new NullException("The userId cannot be null");
        return cardXRMRepositoryLogic.findByUserId(aLong);
    }
}

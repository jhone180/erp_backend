package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.usercase.GetCardXSComponent;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXSRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXS;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetCardXSComponentImpl implements GetCardXSComponent {

    CardXSRepositoryLogic cardXSRepositoryLogic;

    public GetCardXSComponentImpl(CardXSRepositoryLogic cardXSRepositoryLogic) {
        this.cardXSRepositoryLogic = cardXSRepositoryLogic;
    }

    @Override
    public List<CardXS> apply(Long aLong) {
        if (aLong == null) throw new NullException("User id is required");
        return cardXSRepositoryLogic.findByUserId(aLong);
    }
}

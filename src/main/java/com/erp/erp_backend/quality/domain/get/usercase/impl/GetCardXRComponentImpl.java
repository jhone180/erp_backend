package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.usercase.GetCardXRComponent;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetCardXRComponentImpl implements GetCardXRComponent {

    CardXRRepositoryLogic cardXRRepositoryLogic;

    public GetCardXRComponentImpl(CardXRRepositoryLogic cardXRRepositoryLogic){
        this.cardXRRepositoryLogic = cardXRRepositoryLogic;
    }

    @Override
    public List<CardXR> apply(Long aLong) {
        return cardXRRepositoryLogic.findByUserId(aLong);
    }
}

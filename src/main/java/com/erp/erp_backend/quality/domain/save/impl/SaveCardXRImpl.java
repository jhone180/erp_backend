package com.erp.erp_backend.quality.domain.save.impl;

import com.erp.erp_backend.quality.application.request.save.SaveCardXRRequest;
import com.erp.erp_backend.quality.application.request.save.SaveCardsXRRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardXR;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SaveCardXRImpl implements SaveCardXR {

    CardXRRepositoryLogic cardXRRepositoryLogic;

    public SaveCardXRImpl(CardXRRepositoryLogic cardXRRepositoryLogic){
        this.cardXRRepositoryLogic = cardXRRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(SaveCardsXRRequest cardsXRRequest) {
        cardXRRepositoryLogic.createAll(Optional.of(cardsXRRequest.getCardsXR().stream().map(
                cardXRRequest -> createCardXR(cardXRRequest, cardsXRRequest.getUserId())
        ).toList()));
        return PostResponseGeneral.builder()
                .message("The cards XR were created successfully")
                .success(true)
                .build();
    }

    private CardXR createCardXR(SaveCardXRRequest cardXRRequest, Long userId) {
        return CardXR.builder()
                .hours(cardXRRequest.getHours())
                .sample(cardXRRequest.getSample())
                .weight(cardXRRequest.getWeight())
                .userId(userId)
                .build();
    }
}

package com.erp.erp_backend.quality.domain.save.impl;

import com.erp.erp_backend.quality.application.request.save.SaveCardXRMRequest;
import com.erp.erp_backend.quality.application.request.save.SaveCardsXRMRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardXRM;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRMRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SaveCardXRMImpl implements SaveCardXRM {

    CardXRMRepositoryLogic cardXRMRepositoryLogic;

    public SaveCardXRMImpl(CardXRMRepositoryLogic cardXRMRepositoryLogic){
        this.cardXRMRepositoryLogic = cardXRMRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(SaveCardsXRMRequest cardsXRMRequest) {
        cardXRMRepositoryLogic.createAll(Optional.of(cardsXRMRequest.getCardsXRM().stream().map(
                cardXRMRequest -> createCardXRM(cardXRMRequest, cardsXRMRequest.getUserId())
        ).toList()));
        return PostResponseGeneral.builder()
                .message("The cards XRM were created successfully")
                .success(true)
                .build();
    }

    private CardXRM createCardXRM(SaveCardXRMRequest cardXRMRequest, Long userId) {
        return CardXRM.builder()
                .hours(cardXRMRequest.getHours())
                .sample(cardXRMRequest.getSample())
                .weight(cardXRMRequest.getWeight())
                .userId(userId)
                .build();
    }
}

package com.erp.erp_backend.quality.domain.save.impl;

import com.erp.erp_backend.quality.application.request.save.SaveCardXSRequest;
import com.erp.erp_backend.quality.application.request.save.SaveCardsXSRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardXS;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXSRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXS;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SaveCardXSImpl implements SaveCardXS {

    CardXSRepositoryLogic cardXSRepositoryLogic;

    public SaveCardXSImpl(CardXSRepositoryLogic cardXSRepositoryLogic){
        this.cardXSRepositoryLogic = cardXSRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(SaveCardsXSRequest cardsXSRequest) {
        cardXSRepositoryLogic.createAll(Optional.of(cardsXSRequest.getCardsXR().stream().map(
                cardXSRequest -> createCardXS(cardXSRequest, cardsXSRequest.getUserId())
        ).toList()));
        return PostResponseGeneral.builder()
                .message("The cards XRM were created successfully")
                .success(true)
                .build();
    }

    private CardXS createCardXS(SaveCardXSRequest cardXSRequest, Long userId) {
        return CardXS.builder()
                .hours(cardXSRequest.getHours())
                .sample(cardXSRequest.getSample())
                .weight(cardXSRequest.getWeight())
                .userId(userId)
                .build();
    }
}

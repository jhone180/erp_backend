package com.erp.erp_backend.quality.domain.save.impl;

import com.erp.erp_backend.quality.application.request.save.SaveCardURequest;
import com.erp.erp_backend.quality.application.request.save.SaveCardsURequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardU;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardURepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardU;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SaveCardUImpl implements SaveCardU {

    CardURepositoryLogic cardURepositoryLogic;

    public SaveCardUImpl(CardURepositoryLogic cardURepositoryLogic){
        this.cardURepositoryLogic = cardURepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(SaveCardsURequest cardsURequest) {
        cardURepositoryLogic.createAll(Optional.of(cardsURequest.getCardsU().stream().map(
                cardURequest -> createCardU(cardURequest, cardsURequest.getUserId())
        ).toList()));
        return PostResponseGeneral.builder()
                .message("The cards U were created successfully")
                .success(true)
                .build();
    }

    private CardU createCardU(SaveCardURequest cardURequest, Long userId) {
        return CardU.builder()
                .lot(cardURequest.getLot())
                .sampleSize(cardURequest.getSampleSize())
                .totallyDefective(cardURequest.getTotallyDefective())
                .averageNumberDefectsCircuit(cardURequest.getAverageNumberDefectsCircuit())
                .userId(userId)
                .build();
    }
}

package com.erp.erp_backend.quality.domain.save.impl;

import com.erp.erp_backend.quality.application.request.save.SaveCardNPRequest;
import com.erp.erp_backend.quality.application.request.save.SaveCardsNPRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardNP;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardNPRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardNP;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SaveCardNPImpl implements SaveCardNP {

    CardNPRepositoryLogic cardNPRepositoryLogic;

    public SaveCardNPImpl(CardNPRepositoryLogic cardNPRepositoryLogic){
        this.cardNPRepositoryLogic = cardNPRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(SaveCardsNPRequest cardsNPRequest) {
        cardNPRepositoryLogic.createAll(Optional.of(cardsNPRequest.getCardsNP().stream().map(
                cardNPRequest -> createCardNP(cardNPRequest, cardsNPRequest.getUserId())
        ).toList()));
        return PostResponseGeneral.builder()
                .message("The cards C were created successfully")
                .success(true)
                .build();
    }

    private CardNP createCardNP(SaveCardNPRequest cardNPRequest, Long userId) {
        return CardNP.builder()
                .lot(cardNPRequest.getLot())
                .defectiveItemsSample(cardNPRequest.getDefectiveItemsSample())
                .userId(userId)
                .build();
    }
}

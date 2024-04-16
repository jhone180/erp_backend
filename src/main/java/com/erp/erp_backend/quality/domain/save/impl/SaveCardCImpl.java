package com.erp.erp_backend.quality.domain.save.impl;

import com.erp.erp_backend.quality.application.request.save.SaveCardCRequest;
import com.erp.erp_backend.quality.application.request.save.SaveCardsCRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardC;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardCRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardC;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SaveCardCImpl implements SaveCardC {

    CardCRepositoryLogic cardCRepositoryLogic;

    public SaveCardCImpl(CardCRepositoryLogic cardCRepositoryLogic){
        this.cardCRepositoryLogic = cardCRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(SaveCardsCRequest cardsCRequest) {
        cardCRepositoryLogic.createAll(Optional.of(cardsCRequest.getCardsC().stream().map(
                cardCRequest -> createCardC(cardCRequest, cardsCRequest.getUserId())
        ).toList()));
        return PostResponseGeneral.builder()
                .message("The cards C were created successfully")
                .success(true)
                .build();
    }

    private CardC createCardC(SaveCardCRequest cardCRequest, Long userId) {
        return CardC.builder()
                .month(cardCRequest.getMonth())
                .intoxicated(cardCRequest.getIntoxicated())
                .userId(userId)
                .build();
    }
}

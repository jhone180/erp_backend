package com.erp.erp_backend.quality.domain.save.impl;

import com.erp.erp_backend.quality.application.request.save.SaveCardPRequest;
import com.erp.erp_backend.quality.application.request.save.SaveCardsPRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardP;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardPRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardP;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SaveCardPImpl implements SaveCardP {

    CardPRepositoryLogic cardPRepositoryLogic;

    public SaveCardPImpl(CardPRepositoryLogic cardPRepositoryLogic){
        this.cardPRepositoryLogic = cardPRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(SaveCardsPRequest cardsPRequest) {
        cardPRepositoryLogic.createAll(Optional.of(cardsPRequest.getCardsP().stream().map(
                cardPRequest -> createCardP(cardPRequest, cardsPRequest.getUserId())
        ).toList()));
        return PostResponseGeneral.builder()
                .message("The cards P were created successfully")
                .success(true)
                .build();
    }

    private CardP createCardP(SaveCardPRequest cardPRequest, Long userId) {
        return CardP.builder()
                .sample(cardPRequest.getSample())
                .lotSize(cardPRequest.getLotSize())
                .defectiveItems(cardPRequest.getDefectiveItems())
                .proportion(cardPRequest.getProportion())
                .userId(userId)
                .build();
    }
}

package com.erp.erp_backend.quality.domain.get.view.form.impl;

import com.erp.erp_backend.quality.application.response.get.CardPResponse;
import com.erp.erp_backend.quality.domain.get.usercase.GetCardPComponent;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardPComponent;
import com.erp.erp_backend.quality.infrastructure.entity.CardP;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BuildCardPComponentImpl implements BuildCardPComponent {

    GetCardPComponent getCardPComponent;

    public BuildCardPComponentImpl(GetCardPComponent getCardPComponent) {
        this.getCardPComponent = getCardPComponent;
    }

    @Override
    public List<CardPResponse> apply(Long aLong) {
        return getCardPComponent.apply(aLong).stream()
                .map(this::buildCardPResponse)
                .toList();
    }

    private CardPResponse buildCardPResponse(CardP cardP) {
        return CardPResponse.builder()
                .id(cardP.getId())
                .sample(cardP.getSample())
                .lotSize(cardP.getLotSize())
                .defectiveItems(cardP.getDefectiveItems())
                .proportion(cardP.getProportion())
                .build();
    }
}

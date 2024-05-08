package com.erp.erp_backend.quality.domain.get.view.form.impl;

import com.erp.erp_backend.quality.application.response.get.CardUResponse;
import com.erp.erp_backend.quality.domain.get.usercase.GetCardUComponent;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardUComponent;
import com.erp.erp_backend.quality.infrastructure.entity.CardU;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BuildCardUComponentImpl implements BuildCardUComponent {

    GetCardUComponent getCardUComponent;

    public BuildCardUComponentImpl(GetCardUComponent getCardUComponent) {
        this.getCardUComponent = getCardUComponent;
    }

    @Override
    public List<CardUResponse> apply(Long aLong) {
        return getCardUComponent.apply(aLong).stream()
                .map(this::buildCardUResponse)
                .toList();
    }

    private CardUResponse buildCardUResponse(CardU cardU) {
        return CardUResponse.builder()
                .id(cardU.getId())
                .lot(cardU.getLot())
                .sampleSize(cardU.getSampleSize())
                .totallyDefective(cardU.getTotallyDefective())
                .averageNumberDefectsCircuit(cardU.getAverageNumberDefectsCircuit())
                .build();
    }
}

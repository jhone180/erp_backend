package com.erp.erp_backend.quality.domain.get.view.form.impl;

import com.erp.erp_backend.quality.application.response.get.CardCResponse;
import com.erp.erp_backend.quality.domain.get.usercase.GetCardCComponent;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardCComponent;
import com.erp.erp_backend.quality.infrastructure.entity.CardC;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BuildCardCComponentImpl implements BuildCardCComponent {

    GetCardCComponent getCardCComponent;

    public BuildCardCComponentImpl(GetCardCComponent getCardCComponent) {
        this.getCardCComponent = getCardCComponent;
    }

    @Override
    public List<CardCResponse> apply(Long aLong) {
        return getCardCComponent.apply(aLong).stream()
                .map(this::buildCardCResponse).toList();
    }

    private CardCResponse buildCardCResponse(CardC cardC) {
        return CardCResponse.builder()
                .id(cardC.getId())
                .month(cardC.getMonth())
                .intoxicated(cardC.getIntoxicated())
                .build();
    }
}

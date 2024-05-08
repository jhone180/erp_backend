package com.erp.erp_backend.quality.domain.get.view.form.impl;

import com.erp.erp_backend.quality.application.response.get.CardNPResponse;
import com.erp.erp_backend.quality.domain.get.usercase.GetCardNPComponent;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardNPComponent;
import com.erp.erp_backend.quality.infrastructure.entity.CardNP;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BuildCardNPComponentImpl implements BuildCardNPComponent {

    GetCardNPComponent getCardNPComponent;

    public BuildCardNPComponentImpl(GetCardNPComponent getCardNPComponent) {
        this.getCardNPComponent = getCardNPComponent;
    }

    @Override
    public List<CardNPResponse> apply(Long aLong) {
        return getCardNPComponent.apply(aLong).stream()
                .map(this::buildCardNpResponse)
                .toList();
    }

    private CardNPResponse buildCardNpResponse(CardNP cardNP) {
        return CardNPResponse.builder()
                .id(cardNP.getId())
                .lot(cardNP.getLot())
                .defectiveItemsSample(cardNP.getDefectiveItemsSample())
                .build();
    }
}

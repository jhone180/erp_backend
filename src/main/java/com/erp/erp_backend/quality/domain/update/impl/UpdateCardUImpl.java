package com.erp.erp_backend.quality.domain.update.impl;

import com.erp.erp_backend.quality.application.request.update.UpdateCardURequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.update.UpdateCardU;
import com.erp.erp_backend.quality.domain.utils.EqualsUtil;
import com.erp.erp_backend.quality.exception.exceptions.NotFoundException;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardURepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardU;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateCardUImpl implements UpdateCardU {

    CardURepositoryLogic cardURepositoryLogic;

    public UpdateCardUImpl(CardURepositoryLogic cardURepositoryLogic) {
        this.cardURepositoryLogic = cardURepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(UpdateCardURequest updateCardURequest) {
        if (updateCardURequest.getId() == null)
            throw new NullException("The id is required");
        if (updateCardURequest.getUserId() == null)
            throw new NullException("The userId is required");
        cardURepositoryLogic.update(Optional.of(createCardU(updateCardURequest,
                readCardU(updateCardURequest.getId()))));
        return PostResponseGeneral.builder()
                .message("Card U updated successfully")
                .success(true)
                .build();
    }

    private CardU createCardU(UpdateCardURequest updateCardURequest, CardU cardU) {
        return CardU.builder()
                .id(updateCardURequest.getId())
                .lot(EqualsUtil.equalsLongOrNull(cardU.getLot(), updateCardURequest.getLot()))
                .sampleSize(EqualsUtil.equalsLongOrNull(cardU.getSampleSize(), updateCardURequest.getSampleSize()))
                .totallyDefective(EqualsUtil.equalsLongOrNull(cardU.getTotallyDefective(), updateCardURequest.getTotallyDefective()))
                .averageNumberDefectsCircuit(EqualsUtil.equalsDoubleOrNull(cardU.getAverageNumberDefectsCircuit(), updateCardURequest.getAverageNumberDefectsCircuit()))
                .userId(updateCardURequest.getUserId())
                .build();
    }

    private CardU readCardU(Long id) {
        return cardURepositoryLogic.read(id).orElseThrow(() -> new NotFoundException("The card U does not exist"));
    }
}

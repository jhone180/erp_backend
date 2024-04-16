package com.erp.erp_backend.quality.domain.update.impl;

import com.erp.erp_backend.quality.application.request.update.UpdateCardXRRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.update.UpdateCardXR;
import com.erp.erp_backend.quality.domain.utils.EqualsUtil;
import com.erp.erp_backend.quality.exception.exceptions.NotFoundException;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateCardXRImpl implements UpdateCardXR {

    CardXRRepositoryLogic cardXRRepositoryLogic;

    public UpdateCardXRImpl(CardXRRepositoryLogic cardXRRepositoryLogic){
        this.cardXRRepositoryLogic = cardXRRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(UpdateCardXRRequest updateCardXRRequest) {
        if (updateCardXRRequest.getId() == null)
            throw new NullException("The id is required");
        if (updateCardXRRequest.getUserId() == null)
            throw new NullException("The userId is required");
        cardXRRepositoryLogic.update(Optional.of(createCardXR(updateCardXRRequest,
                readCardXR(updateCardXRRequest.getId()))));
        return PostResponseGeneral.builder()
                .message("Card XR updated successfully")
                .success(true)
                .build();
    }

    private CardXR createCardXR(UpdateCardXRRequest updateCardXRRequest, CardXR cardXR){
        return CardXR.builder()
                .id(updateCardXRRequest.getId())
                .sample(EqualsUtil.equalsLongOrNull(cardXR.getSample(), updateCardXRRequest.getSample()))
                .hours(EqualsUtil.equalsLongOrNull(cardXR.getHours(), updateCardXRRequest.getHours()))
                .userId(EqualsUtil.equalsLongOrNull(cardXR.getUserId(), updateCardXRRequest.getUserId()))
                .weight(EqualsUtil.equalsLongOrNull(cardXR.getWeight(), updateCardXRRequest.getWeight()))
                .build();
    }

    private CardXR readCardXR(Long id){
        return cardXRRepositoryLogic.read(id).orElseThrow(() -> new NotFoundException("The card XRM does not exist"));
    }
}

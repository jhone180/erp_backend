package com.erp.erp_backend.quality.domain.update.impl;

import com.erp.erp_backend.quality.application.request.update.UpdateCardXRMRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.update.UpdateCardXRM;
import com.erp.erp_backend.quality.domain.utils.EqualsUtil;
import com.erp.erp_backend.quality.exception.exceptions.NotFoundException;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRMRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateCardXRMImpl implements UpdateCardXRM {

    CardXRMRepositoryLogic cardXRMRepositoryLogic;

    public UpdateCardXRMImpl(CardXRMRepositoryLogic cardXRMRepositoryLogic){
        this.cardXRMRepositoryLogic = cardXRMRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(UpdateCardXRMRequest updateCardXRMRequest) {
        if (updateCardXRMRequest.getId() == null)
            throw new NullException("The id is required");
        if (updateCardXRMRequest.getUserId() == null)
            throw new NullException("The userId is required");
        cardXRMRepositoryLogic.update(Optional.of(createCardXRM(updateCardXRMRequest,
                readCardXRM(updateCardXRMRequest.getId()))));
        return PostResponseGeneral.builder()
                .message("Card XRM updated successfully")
                .success(true)
                .build();
    }

    private CardXRM createCardXRM(UpdateCardXRMRequest updateCardXRMRequest, CardXRM cardXRM){
        return CardXRM.builder()
                .id(updateCardXRMRequest.getId())
                .sample(EqualsUtil.equalsLongOrNull(cardXRM.getSample(), updateCardXRMRequest.getSample()))
                .hours(EqualsUtil.equalsLongOrNull(cardXRM.getHours(), updateCardXRMRequest.getHours()))
                .userId(EqualsUtil.equalsLongOrNull(cardXRM.getUserId(), updateCardXRMRequest.getUserId()))
                .weight(EqualsUtil.equalsLongOrNull(cardXRM.getWeight(), updateCardXRMRequest.getWeight()))
                .build();
    }

    private CardXRM readCardXRM(Long id){
        return cardXRMRepositoryLogic.read(id).orElseThrow(() -> new NotFoundException("The card XRM does not exist"));
    }
}

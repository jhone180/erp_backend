package com.erp.erp_backend.quality.domain.update.impl;

import com.erp.erp_backend.quality.application.request.update.UpdateCardXSRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.update.UpdateCardXS;
import com.erp.erp_backend.quality.domain.utils.EqualsUtil;
import com.erp.erp_backend.quality.exception.exceptions.NotFoundException;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXSRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardXS;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateCardXSImpl implements UpdateCardXS {

    CardXSRepositoryLogic cardXSRepositoryLogic;

    public UpdateCardXSImpl(CardXSRepositoryLogic cardXSRepositoryLogic){
        this.cardXSRepositoryLogic = cardXSRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(UpdateCardXSRequest updateCardXSRequest) {
        if (updateCardXSRequest.getId() == null)
            throw new NullException("The id is required");
        if (updateCardXSRequest.getUserId() == null)
            throw new NullException("The userId is required");
        cardXSRepositoryLogic.update(Optional.of(createCardXS(updateCardXSRequest,
                readCardXS(updateCardXSRequest.getId()))));
        return PostResponseGeneral.builder()
                .message("Card XRM updated successfully")
                .success(true)
                .build();
    }

    private CardXS createCardXS(UpdateCardXSRequest updateCardXSRequest, CardXS cardXS){
        return CardXS.builder()
                .id(updateCardXSRequest.getId())
                .sample(EqualsUtil.equalsLongOrNull(cardXS.getSample(), updateCardXSRequest.getSample()))
                .hours(EqualsUtil.equalsLongOrNull(cardXS.getHours(), updateCardXSRequest.getHours()))
                .userId(EqualsUtil.equalsLongOrNull(cardXS.getUserId(), updateCardXSRequest.getUserId()))
                .weight(EqualsUtil.equalsLongOrNull(cardXS.getWeight(), updateCardXSRequest.getWeight()))
                .build();
    }

    private CardXS readCardXS(Long id){
        return cardXSRepositoryLogic.read(id).orElseThrow(() -> new NotFoundException("The card XRM does not exist"));
    }
}

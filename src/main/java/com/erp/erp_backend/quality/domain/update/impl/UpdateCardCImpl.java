package com.erp.erp_backend.quality.domain.update.impl;

import com.erp.erp_backend.quality.application.request.update.UpdateCardCRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.update.UpdateCardC;
import com.erp.erp_backend.quality.domain.utils.EqualsUtil;
import com.erp.erp_backend.quality.exception.exceptions.NotFoundException;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardCRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardC;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateCardCImpl implements UpdateCardC {

    CardCRepositoryLogic cardCRepositoryLogic;

    public UpdateCardCImpl(CardCRepositoryLogic cardCRepositoryLogic){
        this.cardCRepositoryLogic = cardCRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(UpdateCardCRequest updateCardCRequest) {
        if (updateCardCRequest.getId() == null)
            throw new NullException("The id is required");
        if (updateCardCRequest.getUserId() == null)
            throw new NullException("The userId is required");
        cardCRepositoryLogic.update(Optional.of(createCardC(updateCardCRequest,
                readCardC(updateCardCRequest.getId()))));
        return PostResponseGeneral.builder()
                .message("Card XRM updated successfully")
                .success(true)
                .build();
    }

    private CardC createCardC(UpdateCardCRequest updateCardCRequest, CardC cardC){
        return CardC.builder()
                .id(updateCardCRequest.getId())
                .month(EqualsUtil.equalsLongOrNull(cardC.getMonth(), updateCardCRequest.getMonth()))
                .intoxicated(EqualsUtil.equalsLongOrNull(cardC.getIntoxicated(), updateCardCRequest.getIntoxicated()))
                .userId(EqualsUtil.equalsLongOrNull(cardC.getUserId(), updateCardCRequest.getUserId()))
                .build();
    }

    private CardC readCardC(Long id){
        return cardCRepositoryLogic.read(id).orElseThrow(() -> new NotFoundException("The card XRM does not exist"));
    }
}

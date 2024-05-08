package com.erp.erp_backend.quality.domain.update.impl;

import com.erp.erp_backend.quality.application.request.update.UpdateCardPRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.update.UpdateCardP;
import com.erp.erp_backend.quality.domain.utils.EqualsUtil;
import com.erp.erp_backend.quality.exception.exceptions.NotFoundException;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardPRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardP;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateCardPImpl implements UpdateCardP {

    CardPRepositoryLogic cardPRepositoryLogic;

    public UpdateCardPImpl(CardPRepositoryLogic cardPRepositoryLogic) {
        this.cardPRepositoryLogic = cardPRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(UpdateCardPRequest updateCardPRequest) {
        if (updateCardPRequest.getId() == null)
            throw new NullException("The id is required");
        if (updateCardPRequest.getUserId() == null)
            throw new NullException("The userId is required");
        cardPRepositoryLogic.update(Optional.of(createCardP(updateCardPRequest,
                readCardP(updateCardPRequest.getId()))));
        return PostResponseGeneral.builder()
                .message("Card P updated successfully")
                .success(true)
                .build();
    }

    private CardP createCardP(UpdateCardPRequest updateCardPRequest, CardP cardP) {
        return CardP.builder()
                .id(updateCardPRequest.getId())
                .sample(EqualsUtil.equalsLongOrNull(cardP.getSample(), updateCardPRequest.getSample()))
                .lotSize(EqualsUtil.equalsLongOrNull(cardP.getLotSize(), updateCardPRequest.getLotSize()))
                .defectiveItems(EqualsUtil.equalsLongOrNull(cardP.getDefectiveItems(), updateCardPRequest.getDefectiveItems()))
                .proportion(EqualsUtil.equalsDoubleOrNull(cardP.getProportion(), updateCardPRequest.getProportion()))
                .userId(updateCardPRequest.getUserId())
                .build();
    }

    private CardP readCardP(Long id) {
        return cardPRepositoryLogic.read(id).orElseThrow(() -> new NotFoundException("The card P does not exist"));
    }
}

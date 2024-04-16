package com.erp.erp_backend.quality.domain.update.impl;

import com.erp.erp_backend.quality.application.request.update.UpdateCardNPRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.update.UpdateCardNP;
import com.erp.erp_backend.quality.domain.utils.EqualsUtil;
import com.erp.erp_backend.quality.exception.exceptions.NotFoundException;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardNPRepositoryLogic;
import com.erp.erp_backend.quality.infrastructure.entity.CardNP;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateCardNPImpl implements UpdateCardNP {

    CardNPRepositoryLogic cardNPRepositoryLogic;

    public UpdateCardNPImpl(CardNPRepositoryLogic cardNPRepositoryLogic){
        this.cardNPRepositoryLogic = cardNPRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(UpdateCardNPRequest updateCardNPRequest) {
        if (updateCardNPRequest.getId() == null)
            throw new NullException("The id is required");
        if (updateCardNPRequest.getUserId() == null)
            throw new NullException("The userId is required");
        cardNPRepositoryLogic.update(Optional.of(createCardNP(updateCardNPRequest,
                readCardNP(updateCardNPRequest.getId()))));
        return PostResponseGeneral.builder()
                .message("Card NP updated successfully")
                .success(true)
                .build();
    }

    private CardNP createCardNP(UpdateCardNPRequest updateCardNPRequest, CardNP cardNP){
        return CardNP.builder()
                .id(updateCardNPRequest.getId())
                .lot(EqualsUtil.equalsLongOrNull(cardNP.getLot(), updateCardNPRequest.getLot()))
                .defectiveItemsSample(EqualsUtil.equalsLongOrNull(cardNP.getDefectiveItemsSample(), updateCardNPRequest.getDefectiveItemsSample()))
                .build();
    }

    private CardNP readCardNP(Long id){
        return cardNPRepositoryLogic.read(id).orElseThrow(() -> new NotFoundException("The card NP does not exist"));
    }
}

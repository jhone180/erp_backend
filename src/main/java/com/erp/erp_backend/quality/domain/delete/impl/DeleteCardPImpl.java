package com.erp.erp_backend.quality.domain.delete.impl;

import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.delete.DeleteCardP;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardPRepositoryLogic;
import org.springframework.stereotype.Service;

@Service
public class DeleteCardPImpl implements DeleteCardP {

    CardPRepositoryLogic cardPRepositoryLogic;

    public DeleteCardPImpl(CardPRepositoryLogic cardPRepositoryLogic) {
        this.cardPRepositoryLogic = cardPRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(Long aLong) {
        cardPRepositoryLogic.delete(aLong);
        return PostResponseGeneral.builder()
                .success(true)
                .message("All data Cart P has been successfully deleted.")
                .build();
    }
}

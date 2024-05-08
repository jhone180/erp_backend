package com.erp.erp_backend.quality.domain.delete.impl;

import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.delete.DeleteCardC;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardCRepositoryLogic;
import org.springframework.stereotype.Service;

@Service
public class DeleteCardCImpl implements DeleteCardC {

    CardCRepositoryLogic cardCRepositoryLogic;

    public DeleteCardCImpl(CardCRepositoryLogic cardCRepositoryLogic) {
        this.cardCRepositoryLogic = cardCRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(Long aLong) {
        cardCRepositoryLogic.delete(aLong);
        return PostResponseGeneral.builder()
                .success(true)
                .message("All data Cart C has been successfully deleted.")
                .build();
    }
}

package com.erp.erp_backend.quality.domain.delete.impl;

import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.delete.DeleteCardU;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardURepositoryLogic;
import org.springframework.stereotype.Service;

@Service
public class DeleteCardUImpl implements DeleteCardU {

    CardURepositoryLogic cardURepositoryLogic;

    public DeleteCardUImpl(CardURepositoryLogic cardURepositoryLogic) {
        this.cardURepositoryLogic = cardURepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(Long aLong) {
        cardURepositoryLogic.delete(aLong);
        return PostResponseGeneral.builder()
                .success(true)
                .message("All data Cart U has been successfully deleted.")
                .build();
    }
}

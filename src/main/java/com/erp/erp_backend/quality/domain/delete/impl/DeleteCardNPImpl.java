package com.erp.erp_backend.quality.domain.delete.impl;

import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.delete.DeleteCardNP;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardNPRepositoryLogic;
import org.springframework.stereotype.Service;

@Service
public class DeleteCardNPImpl implements DeleteCardNP {

    CardNPRepositoryLogic cardNPRepositoryLogic;

    public DeleteCardNPImpl(CardNPRepositoryLogic cardNPRepositoryLogic) {
        this.cardNPRepositoryLogic = cardNPRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(Long aLong) {
        cardNPRepositoryLogic.delete(aLong);
        return PostResponseGeneral.builder()
                .success(true)
                .message("All data Cart NP has been successfully deleted.")
                .build();
    }
}

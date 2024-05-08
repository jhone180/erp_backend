package com.erp.erp_backend.quality.domain.delete.impl;

import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.delete.DeleteCardXS;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXSRepositoryLogic;
import org.springframework.stereotype.Service;

@Service
public class DeleteCardXSImpl implements DeleteCardXS {

    CardXSRepositoryLogic cardXSRepositoryLogic;

    public DeleteCardXSImpl(CardXSRepositoryLogic cardXSRepositoryLogic) {
        this.cardXSRepositoryLogic = cardXSRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(Long aLong) {
        cardXSRepositoryLogic.delete(aLong);
        return PostResponseGeneral.builder()
                .success(true)
                .message("All data Cart XS has been successfully deleted.")
                .build();
    }
}

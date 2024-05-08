package com.erp.erp_backend.quality.domain.delete.impl;

import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.delete.DeleteCardXRM;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRMRepositoryLogic;
import org.springframework.stereotype.Service;

@Service
public class DeleteCardXRMImpl implements DeleteCardXRM {

    CardXRMRepositoryLogic cardXRMRepositoryLogic;

    public DeleteCardXRMImpl(CardXRMRepositoryLogic cardXRMRepositoryLogic) {
        this.cardXRMRepositoryLogic = cardXRMRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(Long aLong) {
        cardXRMRepositoryLogic.delete(aLong);
        return PostResponseGeneral.builder()
                .success(true)
                .message("All data Cart XRM has been successfully deleted.")
                .build();
    }
}

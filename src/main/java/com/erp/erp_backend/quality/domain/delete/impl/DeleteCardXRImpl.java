package com.erp.erp_backend.quality.domain.delete.impl;

import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.delete.DeleteCardXR;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRRepositoryLogic;
import org.springframework.stereotype.Service;

@Service
public class DeleteCardXRImpl implements DeleteCardXR {

    CardXRRepositoryLogic cardXRRepositoryLogic;

    public DeleteCardXRImpl(CardXRRepositoryLogic cardXRRepositoryLogic) {
        this.cardXRRepositoryLogic = cardXRRepositoryLogic;
    }

    @Override
    public PostResponseGeneral apply(Long aLong) {
        cardXRRepositoryLogic.delete(aLong);
        return PostResponseGeneral.builder()
                .success(true)
                .message("All data Cart XR has been successfully deleted.")
                .build();
    }
}

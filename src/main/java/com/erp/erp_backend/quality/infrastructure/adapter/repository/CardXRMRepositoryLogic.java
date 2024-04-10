package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import com.erp.erp_backend.quality.infrastructure.port.repository.CardXRMRepository;

import java.util.Optional;

public interface CardXRMRepositoryLogic {

    void save(Optional<CardXRM> cardXRM);

    CardXRM findByUserId(Long userId);

    CardXRM modify();

}

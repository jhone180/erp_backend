package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;

public interface CardXRRepositoryLogic extends CrudRepository<CardXR, Long> {

    CardXRM findByUserId(Long userId);
}

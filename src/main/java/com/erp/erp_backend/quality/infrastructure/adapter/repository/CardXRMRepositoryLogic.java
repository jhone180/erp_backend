package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;

public interface CardXRMRepositoryLogic extends CrudRepository<CardXRM, Long> {

    CardXRM findByUserId(Long userId);
}

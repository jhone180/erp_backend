package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardXS;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;

public interface CardXSRepositoryLogic extends CrudRepository<CardXS, Long> {

    CardXS findByUserId(Long userId);
}

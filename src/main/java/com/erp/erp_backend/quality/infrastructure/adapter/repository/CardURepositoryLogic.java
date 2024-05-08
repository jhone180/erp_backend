package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardU;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;
import java.util.List;

public interface CardURepositoryLogic extends CrudRepository<CardU, Long> {
    List<CardU> findByUserId(Long userId);
}

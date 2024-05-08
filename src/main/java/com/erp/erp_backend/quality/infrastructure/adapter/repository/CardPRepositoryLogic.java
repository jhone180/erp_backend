package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardP;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;
import java.util.List;

public interface CardPRepositoryLogic extends CrudRepository<CardP, Long> {

    List<CardP> findByUserId(Long userId);

}

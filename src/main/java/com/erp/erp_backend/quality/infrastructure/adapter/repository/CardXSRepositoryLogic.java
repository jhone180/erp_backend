package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.domain.get.objects.AverageDeviationsRange;
import com.erp.erp_backend.quality.infrastructure.entity.CardXS;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;
import java.util.List;

public interface CardXSRepositoryLogic extends CrudRepository<CardXS, Long> {

    List<CardXS> findByUserId(Long userId);

    List<AverageDeviationsRange> getAverageDeviationsRange(Long userId);
}

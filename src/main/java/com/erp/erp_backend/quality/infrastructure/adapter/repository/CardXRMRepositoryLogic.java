package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.domain.get.objects.AverageAndRange;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;
import java.util.List;

public interface CardXRMRepositoryLogic extends CrudRepository<CardXRM, Long> {

    List<CardXRM> findByUserId(Long userId);

    List<AverageAndRange> getAverageAndRange(Long userId);
}

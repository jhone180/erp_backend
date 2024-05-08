package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.domain.get.objects.AverageAndRange;
import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;
import java.util.List;

public interface    CardXRRepositoryLogic extends CrudRepository<CardXR, Long> {

    List<CardXR> findByUserId(Long userId);

    List<AverageAndRange> getAverageAndRange(Long userId);
}

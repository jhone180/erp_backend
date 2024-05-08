package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardNP;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;
import java.util.List;

public interface CardNPRepositoryLogic extends CrudRepository<CardNP, Long> {

    List<CardNP> findByUserId(Long cardId);

}

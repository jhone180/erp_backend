package com.erp.erp_backend.quality.infrastructure.adapter.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardC;
import com.erp.erp_backend.quality.infrastructure.port.repository.CrudRepository;
import java.util.List;

public interface CardCRepositoryLogic extends CrudRepository<CardC, Long> {

    List<CardC> findByUserId(Long cardId);
}

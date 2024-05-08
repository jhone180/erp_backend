package com.erp.erp_backend.quality.infrastructure.port.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CardCRepository extends JpaRepository<CardC, Long> {

    List<CardC> findByUserId(Long cardId);

    @Transactional
    void deleteByUserId(Long userId);
}

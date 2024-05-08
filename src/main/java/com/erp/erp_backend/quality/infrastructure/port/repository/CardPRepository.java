package com.erp.erp_backend.quality.infrastructure.port.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardP;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CardPRepository extends JpaRepository<CardP, Long> {

    List<CardP> findByUserId(Long userId);

    @Transactional
    void deleteByUserId(Long userId);

}

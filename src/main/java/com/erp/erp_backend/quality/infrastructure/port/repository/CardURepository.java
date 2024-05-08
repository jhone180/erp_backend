package com.erp.erp_backend.quality.infrastructure.port.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardU;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CardURepository extends JpaRepository<CardU, Long> {

    List<CardU> findByUserId(Long userId);

    @Transactional
    void deleteByUserId(Long userId);
}

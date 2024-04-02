package com.erp.erp_backend.quality.port.repository;

import com.erp.erp_backend.quality.domain.entity.CardNP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardNPRepository extends JpaRepository<CardNP, Long> {
}

package com.erp.erp_backend.quality.port.repository;

import com.erp.erp_backend.quality.domain.entity.CardXS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardXSRepository extends JpaRepository<CardXS, Long> {
}

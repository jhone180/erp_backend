package com.erp.erp_backend.quality.infrastructure.port.repository;

import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardXRMRepository extends JpaRepository<CardXRM, Long> {
}

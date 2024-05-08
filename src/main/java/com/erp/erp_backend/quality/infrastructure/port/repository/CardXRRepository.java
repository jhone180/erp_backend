package com.erp.erp_backend.quality.infrastructure.port.repository;

import com.erp.erp_backend.quality.domain.get.objects.AverageAndRange;
import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CardXRRepository extends JpaRepository<CardXR, Long> {

    List<CardXR> findByUserId(Long userId);

    @Query("SELECT new com.erp.erp_backend.quality.domain.get.objects.AverageAndRange(cxr.sample, AVG(cxr.weight), (MAX(cxr.weight) - MIN(cxr.weight))) FROM CardXR cxr WHERE cxr.userId = :userId GROUP BY cxr.sample")
    List<AverageAndRange> getAverageAndRange(@Param("userId") Long userId);

    @Transactional
    void deleteByUserId(Long userId);
}

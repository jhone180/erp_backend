package com.erp.erp_backend.quality.infrastructure.port.repository;

import com.erp.erp_backend.quality.domain.get.objects.AverageAndRange;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CardXRMRepository extends JpaRepository<CardXRM, Long> {

    List<CardXRM> findByUserId(Long userId);

    @Query("SELECT new com.erp.erp_backend.quality.domain.get.objects.AverageAndRange(cxrm.sample, AVG(cxrm.weight), (MAX(cxrm.weight) - MIN(cxrm.weight))) FROM CardXRM cxrm WHERE cxrm.userId = :userId GROUP BY cxrm.sample")
    List<AverageAndRange> getAverageAndRange(@Param("userId") Long userId);

    @Transactional
    void deleteByUserId(Long userId);
}

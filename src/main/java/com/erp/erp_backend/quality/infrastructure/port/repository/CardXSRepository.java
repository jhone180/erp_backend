package com.erp.erp_backend.quality.infrastructure.port.repository;

import com.erp.erp_backend.quality.domain.get.objects.AverageDeviationsRange;
import com.erp.erp_backend.quality.infrastructure.entity.CardXS;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CardXSRepository extends JpaRepository<CardXS, Long> {

    List<CardXS> findByUserId(Long userId);

    @Query("SELECT new com.erp.erp_backend.quality.domain.get.objects.AverageDeviationsRange(cxs.sample, AVG(cxs.weight), STDDEV(cxs.weight), (MAX(cxs.weight) - MIN(cxs.weight))) FROM CardXS cxs WHERE cxs.userId = :userId GROUP BY cxs.sample")
    List<AverageDeviationsRange> getAverageDeviationsRange(@Param("userId") Long userId);

    @Transactional
    void deleteByUserId(Long userId);
}

package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.objects.AverageDeviationsRange;
import com.erp.erp_backend.quality.domain.get.usercase.GetAverageDeviationRange;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXSRepositoryLogic;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetAverageDeviationRangeImpl implements GetAverageDeviationRange {

    CardXSRepositoryLogic cardXSRepositoryLogic;

    public GetAverageDeviationRangeImpl(CardXSRepositoryLogic cardXSRepositoryLogic) {
        this.cardXSRepositoryLogic = cardXSRepositoryLogic;
    }

    @Override
    public List<AverageDeviationsRange> apply(Long aLong) {
        if (aLong == null)
            throw new NullException("User id cannot be null");
        return cardXSRepositoryLogic.getAverageDeviationsRange(aLong);
    }
}

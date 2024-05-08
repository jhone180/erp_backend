package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.objects.AverageAndRange;
import com.erp.erp_backend.quality.domain.get.usercase.GetAverageAndRangeXR;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRRepositoryLogic;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetAverageAndRangeXRImpl implements GetAverageAndRangeXR {

    CardXRRepositoryLogic cardXRRepositoryLogic;

    public GetAverageAndRangeXRImpl(CardXRRepositoryLogic cardXRRepositoryLogic){
        this.cardXRRepositoryLogic = cardXRRepositoryLogic;
    }

    @Override
    public List<AverageAndRange> apply(Long aLong) {
        return cardXRRepositoryLogic.getAverageAndRange(aLong);
    }
}

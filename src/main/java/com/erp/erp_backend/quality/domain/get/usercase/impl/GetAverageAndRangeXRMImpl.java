package com.erp.erp_backend.quality.domain.get.usercase.impl;

import com.erp.erp_backend.quality.domain.get.objects.AverageAndRange;
import com.erp.erp_backend.quality.domain.get.usercase.GetAverageAndRangeXRM;
import com.erp.erp_backend.quality.exception.exceptions.NullException;
import com.erp.erp_backend.quality.infrastructure.adapter.repository.CardXRMRepositoryLogic;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetAverageAndRangeXRMImpl implements GetAverageAndRangeXRM {

    CardXRMRepositoryLogic cardXRMRepositoryLogic;

    public GetAverageAndRangeXRMImpl(CardXRMRepositoryLogic cardXRMRepositoryLogic){
        this.cardXRMRepositoryLogic = cardXRMRepositoryLogic;
    }

    @Override
    public List<AverageAndRange> apply(Long aLong) {
        if (aLong == null) throw new NullException("User id cannot be null");
        return cardXRMRepositoryLogic.getAverageAndRange(aLong);
    }
}

package com.erp.erp_backend.quality.domain.get.view.form.impl;

import com.erp.erp_backend.quality.application.response.get.CardXRMResponse;
import com.erp.erp_backend.quality.domain.get.objects.AverageAndRange;
import com.erp.erp_backend.quality.domain.get.usercase.GetAverageAndRangeXRM;
import com.erp.erp_backend.quality.domain.get.usercase.GetCardXRMComponent;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardXRMComponent;
import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BuildCardXRMComponentImpl implements BuildCardXRMComponent {

    GetCardXRMComponent getCardXRMComponent;

    GetAverageAndRangeXRM getAverageAndRangeXRM;

    public BuildCardXRMComponentImpl(GetCardXRMComponent getCardXRMComponent, GetAverageAndRangeXRM getAverageAndRangeXRM){
        this.getCardXRMComponent = getCardXRMComponent;
        this.getAverageAndRangeXRM = getAverageAndRangeXRM;
    }

    @Override
    public List<CardXRMResponse> apply(Long aLong) {
        List<CardXRM> cardXRMS = getCardXRMComponent.apply(aLong);
        List<AverageAndRange> averageAndRanges = getAverageAndRangeXRM.apply(aLong);
        Map<Long, AverageAndRange> averageAndRangesMap = averageAndRanges.stream()
                .collect(Collectors.toMap(AverageAndRange::getId, Function.identity()));


        return cardXRMS.stream()
                .map(cardXR -> buildCardXrmResponse(cardXR, averageAndRangesMap.get(cardXR.getSample())))
                .collect(Collectors.toList());
    }

    private CardXRMResponse buildCardXrmResponse(CardXRM cardXRM, AverageAndRange averageAndRange) {
        return CardXRMResponse.builder()
                .id(cardXRM.getId())
                .hours(cardXRM.getHours())
                .sample(cardXRM.getSample())
                .weight(cardXRM.getWeight())
                .average(averageAndRange.getAverage())
                .range(averageAndRange.getRange())
                .build();
    }
}

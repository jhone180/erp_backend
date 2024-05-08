package com.erp.erp_backend.quality.domain.get.view.form.impl;

import com.erp.erp_backend.quality.application.response.get.CardXRResponse;
import com.erp.erp_backend.quality.domain.get.objects.AverageAndRange;
import com.erp.erp_backend.quality.domain.get.usercase.GetAverageAndRangeXR;
import com.erp.erp_backend.quality.domain.get.usercase.GetCardXRComponent;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardXRComponent;
import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BuildCardXRComponentImpl implements BuildCardXRComponent {

    GetCardXRComponent getCardXRComponent;

    GetAverageAndRangeXR getAverageAndRangeXR;

    public BuildCardXRComponentImpl(GetCardXRComponent getCardXRComponent,
                                    GetAverageAndRangeXR getAverageAndRangeXR){
        this.getCardXRComponent = getCardXRComponent;
        this.getAverageAndRangeXR = getAverageAndRangeXR;
    }

    @Override
    public List<CardXRResponse> apply(Long aLong) {
        List<CardXR> cardXRS = getCardXRComponent.apply(aLong);
        List<AverageAndRange> averageAndRanges = getAverageAndRangeXR.apply(aLong);
        Map<Long, AverageAndRange> averageAndRangesMap = averageAndRanges.stream()
                .collect(Collectors.toMap(AverageAndRange::getId, Function.identity()));


        return cardXRS.stream()
                .map(cardXR -> buildCardXrResponse(cardXR, averageAndRangesMap.get(cardXR.getSample())))
                .collect(Collectors.toList());
    }

    private CardXRResponse buildCardXrResponse(CardXR cardXR, AverageAndRange averageAndRange) {
        return CardXRResponse.builder()
                .id(cardXR.getId())
                .hours(cardXR.getHours())
                .sample(cardXR.getSample())
                .weight(cardXR.getWeight())
                .average(averageAndRange.getAverage())
                .range(averageAndRange.getRange())
                .build();
    }
}

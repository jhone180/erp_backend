package com.erp.erp_backend.quality.domain.get.view.form.impl;

import com.erp.erp_backend.quality.application.response.get.CardXSResponse;
import com.erp.erp_backend.quality.domain.get.objects.AverageDeviationsRange;
import com.erp.erp_backend.quality.domain.get.usercase.GetAverageDeviationRange;
import com.erp.erp_backend.quality.domain.get.usercase.GetCardXSComponent;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardXSComponent;
import com.erp.erp_backend.quality.infrastructure.entity.CardXS;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BuildCardXSComponentImpl implements BuildCardXSComponent {

    GetCardXSComponent getCardXSComponent;

    GetAverageDeviationRange getAverageDeviationRange;

    public BuildCardXSComponentImpl(GetCardXSComponent getCardXSComponent, GetAverageDeviationRange getAverageDeviationRange) {
        this.getCardXSComponent = getCardXSComponent;
        this.getAverageDeviationRange = getAverageDeviationRange;
    }

    @Override
    public List<CardXSResponse> apply(Long aLong) {
        List<CardXS> cardXSS = getCardXSComponent.apply(aLong);
        List<AverageDeviationsRange> averageDeviationsRanges = getAverageDeviationRange.apply(aLong);
        Map<Long, AverageDeviationsRange> averageDeviationsRangesMap = averageDeviationsRanges.stream()
                .collect(Collectors.toMap(AverageDeviationsRange::getId, Function.identity()));

        return cardXSS.stream()
                .map(cardXS -> buildCardXSResponse(cardXS, averageDeviationsRangesMap.get(cardXS.getSample())))
                .toList();
    }

    private CardXSResponse buildCardXSResponse(CardXS cardXS, AverageDeviationsRange averageDeviationsRange) {
        return CardXSResponse.builder()
                .id(cardXS.getId())
                .hours(cardXS.getHours())
                .sample(cardXS.getSample())
                .weight(cardXS.getWeight())
                .average(averageDeviationsRange.getAverage())
                .deviations(averageDeviationsRange.getDeviations())
                .range(averageDeviationsRange.getRange())
                .build();
    }
}

package com.erp.erp_backend.quality.domain.get.usercase;

import com.erp.erp_backend.quality.domain.get.objects.AverageDeviationsRange;
import java.util.List;
import java.util.function.Function;

public interface GetAverageDeviationRange extends Function<Long, List<AverageDeviationsRange>> {
}

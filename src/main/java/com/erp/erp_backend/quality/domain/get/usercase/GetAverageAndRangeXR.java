package com.erp.erp_backend.quality.domain.get.usercase;

import com.erp.erp_backend.quality.domain.get.objects.AverageAndRange;
import java.util.List;
import java.util.function.Function;

public interface GetAverageAndRangeXR extends Function<Long, List<AverageAndRange>> {
}

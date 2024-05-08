package com.erp.erp_backend.quality.domain.get.usercase;

import com.erp.erp_backend.quality.infrastructure.entity.CardU;
import java.util.List;
import java.util.function.Function;

public interface GetCardUComponent  extends Function<Long, List<CardU>> {
}

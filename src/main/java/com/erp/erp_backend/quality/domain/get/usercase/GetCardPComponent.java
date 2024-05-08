package com.erp.erp_backend.quality.domain.get.usercase;

import com.erp.erp_backend.quality.infrastructure.entity.CardP;
import java.util.List;
import java.util.function.Function;

public interface GetCardPComponent extends Function<Long, List<CardP>> {
}

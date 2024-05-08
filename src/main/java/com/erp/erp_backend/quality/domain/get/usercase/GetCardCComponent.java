package com.erp.erp_backend.quality.domain.get.usercase;

import com.erp.erp_backend.quality.infrastructure.entity.CardC;
import java.util.List;
import java.util.function.Function;

public interface GetCardCComponent extends Function<Long, List<CardC>> {
}

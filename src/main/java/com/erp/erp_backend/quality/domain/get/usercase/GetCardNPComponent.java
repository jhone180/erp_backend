package com.erp.erp_backend.quality.domain.get.usercase;

import com.erp.erp_backend.quality.infrastructure.entity.CardNP;
import java.util.List;
import java.util.function.Function;

public interface GetCardNPComponent extends Function<Long, List<CardNP>> {
}

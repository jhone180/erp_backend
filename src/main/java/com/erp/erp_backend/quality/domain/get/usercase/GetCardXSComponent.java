package com.erp.erp_backend.quality.domain.get.usercase;

import com.erp.erp_backend.quality.infrastructure.entity.CardXS;
import java.util.List;
import java.util.function.Function;

public interface GetCardXSComponent extends Function<Long, List<CardXS>> {
}

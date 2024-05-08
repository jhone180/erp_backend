package com.erp.erp_backend.quality.domain.get.usercase;

import com.erp.erp_backend.quality.infrastructure.entity.CardXRM;
import java.util.List;
import java.util.function.Function;

public interface GetCardXRMComponent extends Function<Long, List<CardXRM>> {
}

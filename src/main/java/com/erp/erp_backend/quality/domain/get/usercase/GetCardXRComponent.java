package com.erp.erp_backend.quality.domain.get.usercase;

import com.erp.erp_backend.quality.infrastructure.entity.CardXR;
import java.util.List;
import java.util.function.Function;

public interface GetCardXRComponent extends Function<Long, List<CardXR>> {
}

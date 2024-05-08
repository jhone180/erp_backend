package com.erp.erp_backend.quality.domain.get.view.form;

import com.erp.erp_backend.quality.application.response.get.CardXRResponse;
import java.util.List;
import java.util.function.Function;

public interface BuildCardXRComponent extends Function<Long, List<CardXRResponse>> {
}

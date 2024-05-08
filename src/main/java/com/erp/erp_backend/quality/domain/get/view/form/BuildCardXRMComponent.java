package com.erp.erp_backend.quality.domain.get.view.form;

import com.erp.erp_backend.quality.application.response.get.CardXRMResponse;
import java.util.List;
import java.util.function.Function;

public interface BuildCardXRMComponent extends Function<Long, List<CardXRMResponse>> {
}

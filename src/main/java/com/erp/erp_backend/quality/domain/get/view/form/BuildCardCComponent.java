package com.erp.erp_backend.quality.domain.get.view.form;

import com.erp.erp_backend.quality.application.response.get.CardCResponse;
import java.util.List;
import java.util.function.Function;

public interface BuildCardCComponent extends Function<Long, List<CardCResponse>> {
}

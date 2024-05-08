package com.erp.erp_backend.quality.domain.get.view.form;

import com.erp.erp_backend.quality.application.response.get.CardPResponse;
import java.util.List;
import java.util.function.Function;

public interface BuildCardPComponent extends Function<Long, List<CardPResponse>> {
}

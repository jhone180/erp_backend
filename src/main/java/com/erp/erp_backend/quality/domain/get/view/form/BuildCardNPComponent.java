package com.erp.erp_backend.quality.domain.get.view.form;

import com.erp.erp_backend.quality.application.response.get.CardNPResponse;
import java.util.List;
import java.util.function.Function;

public interface BuildCardNPComponent extends Function<Long, List<CardNPResponse>> {
}

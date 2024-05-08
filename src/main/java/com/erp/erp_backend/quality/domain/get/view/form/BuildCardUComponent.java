package com.erp.erp_backend.quality.domain.get.view.form;

import com.erp.erp_backend.quality.application.response.get.CardUResponse;
import java.util.List;
import java.util.function.Function;

public interface BuildCardUComponent extends Function<Long, List<CardUResponse>> {
}

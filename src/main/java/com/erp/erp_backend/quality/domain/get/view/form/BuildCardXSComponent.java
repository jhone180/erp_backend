package com.erp.erp_backend.quality.domain.get.view.form;

import com.erp.erp_backend.quality.application.response.get.CardXSResponse;
import java.util.List;
import java.util.function.Function;

public interface BuildCardXSComponent extends Function<Long, List<CardXSResponse>> {
}

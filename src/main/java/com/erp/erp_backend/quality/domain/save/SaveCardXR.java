package com.erp.erp_backend.quality.domain.save;

import com.erp.erp_backend.quality.application.request.save.SaveCardsXRRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import java.util.function.Function;

public interface SaveCardXR extends Function<SaveCardsXRRequest, PostResponseGeneral> {

}

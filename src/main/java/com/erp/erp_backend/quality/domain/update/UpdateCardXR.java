package com.erp.erp_backend.quality.domain.update;

import com.erp.erp_backend.quality.application.request.update.UpdateCardXRRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import java.util.function.Function;

public interface UpdateCardXR extends Function<UpdateCardXRRequest, PostResponseGeneral> {
}

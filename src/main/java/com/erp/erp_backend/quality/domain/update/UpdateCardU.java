package com.erp.erp_backend.quality.domain.update;

import com.erp.erp_backend.quality.application.request.update.UpdateCardURequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import java.util.function.Function;

public interface UpdateCardU extends Function<UpdateCardURequest, PostResponseGeneral> {
}

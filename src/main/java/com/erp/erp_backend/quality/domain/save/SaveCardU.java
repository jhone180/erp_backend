package com.erp.erp_backend.quality.domain.save;

import com.erp.erp_backend.quality.application.request.save.SaveCardsURequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import java.util.function.Function;

public interface SaveCardU extends Function<SaveCardsURequest, PostResponseGeneral> {
}

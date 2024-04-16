package com.erp.erp_backend.quality.domain.save;

import com.erp.erp_backend.quality.application.request.save.SaveCardsXSRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import java.util.function.Function;

public interface SaveCardXS extends Function<SaveCardsXSRequest, PostResponseGeneral> {

}

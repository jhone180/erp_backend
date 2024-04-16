package com.erp.erp_backend.quality.domain.update;

import com.erp.erp_backend.quality.application.request.update.UpdateCardPRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import java.util.function.Function;

public interface UpdateCardP extends Function<UpdateCardPRequest, PostResponseGeneral> {
}

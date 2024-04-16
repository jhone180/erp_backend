package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardNPRequest {

    @JsonProperty("lot")
    @NotNull(message = "lot is required")
    @Positive(message = "lot must be positive")
    private Long lot;
    @JsonProperty("defective_items_sample")
    @NotNull(message = "defective_items_sample is required")
    @Positive(message = "defective_items_sample must be positive")
    private Long defectiveItemsSample;
}

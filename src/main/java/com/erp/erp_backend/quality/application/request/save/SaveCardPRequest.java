package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardPRequest {

    @JsonProperty("sample")
    @NotNull(message = "sample is required")
    @Positive(message = "sample must be greater than 0")
    private Long sample;
    @JsonProperty("lot_size")
    @NotNull(message = "lot_size is required")
    @Positive(message = "lot_size must be greater than 0")
    private Long lotSize;
    @JsonProperty("defective_items")
    @NotNull(message = "defective_items is required")
    @Positive(message = "defective_items must be greater than 0")
    private Long defectiveItems;
    @JsonProperty("proportion")
    @NotNull(message = "proportion is required")
    @Positive(message = "proportion must be greater than 0")
    private Double proportion;
}

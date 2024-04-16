package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardCRequest {

    @JsonProperty("month")
    @NotNull(message = "month is required")
    @Positive(message = "month must be greater than 0")
    private Long month;
    @JsonProperty("intoxicated")
    @NotNull(message = "intoxicated is required")
    @Positive(message = "month must be greater than 0")
    private Long intoxicated;
}

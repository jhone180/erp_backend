package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardXRMRequest {

    @NotNull(message = "The hours is required")
    @Positive(message = "The hours must be greater than zero")
    @JsonProperty("hours")
    private Long hours;
    @NotNull(message = "The sample is required")
    @Positive(message = "The sample must be greater than zero")
    @JsonProperty("sample")
    private Long sample;
    @NotNull(message = "The weight is required")
    @Positive(message = "The weight must be greater than zero")
    @JsonProperty("weight")
    private Long weight;
}

package com.erp.erp_backend.quality.application.request.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateCardXSRequest {

    @NotNull(message = "The id is required")
    @Positive(message = "The sample must be greater than zero")
    private Long id;
    private Long hours;
    private Long sample;
    private Long weight;
    @JsonProperty("user_id")
    @NotNull(message = "The user_id is required")
    @Positive(message = "The sample must be greater than zero")
    private Long userId;
}


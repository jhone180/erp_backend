package com.erp.erp_backend.quality.application.request.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateCardURequest {

    @JsonProperty("id")
    @NotNull(message = "id is required")
    @Positive(message = "id must be greater than 0")
    private Long id;
    @JsonProperty("lot")
    private Long lot;
    @JsonProperty("sample_size")
    private Long sampleSize;
    @JsonProperty("totally_defective")
    private Long totallyDefective;
    @JsonProperty("average_number_defects_circuit")
    private Long averageNumberDefectsCircuit;
    @JsonProperty("user_id")
    @NotNull(message = "user_id is required")
    @Positive(message = "id must be greater than 0")
    private Long userId;
}

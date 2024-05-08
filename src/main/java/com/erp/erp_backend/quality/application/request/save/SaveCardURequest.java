package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardURequest {

    @JsonProperty("lot")
    @NotNull(message = "lot is required")
    @Positive(message = "lot must be greater than 0")
    private Long lot;
    @JsonProperty("sample_size")
    @NotNull(message = "sample_size is required")
    @Positive(message = "sample_size must be greater than 0")
    private Long sampleSize;
    @JsonProperty("totally_defective")
    @NotNull(message = "totally_defective is required")
    @Positive(message = "totally_defective must be greater than 0")
    private Long totallyDefective;
    @JsonProperty("average_number_defects_circuit")
    @NotNull(message = "average_number_defects_circuit is required")
    @Positive(message = "average_number_defects_circuit must be greater than 0")
    private Double averageNumberDefectsCircuit;
}

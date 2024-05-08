package com.erp.erp_backend.quality.application.response.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CardUResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("lot")
    private Long lot;
    @JsonProperty("sample_size")
    private Long sampleSize;
    @JsonProperty("totally_defective")
    private Long totallyDefective;
    @JsonProperty("average_number_defects_circuit")
    private Double averageNumberDefectsCircuit;
}

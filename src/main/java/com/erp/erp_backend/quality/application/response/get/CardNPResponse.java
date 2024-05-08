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
public class CardNPResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("lot")
    private Long lot;
    @JsonProperty("defective_items_sample")
    private Long defectiveItemsSample;
}

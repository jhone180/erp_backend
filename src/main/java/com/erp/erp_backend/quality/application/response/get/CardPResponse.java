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
public class CardPResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("sample")
    private Long sample;
    @JsonProperty("lot_size")
    private Long lotSize;
    @JsonProperty("defective_items")
    private Long defectiveItems;
    @JsonProperty("proportion")
    private Double proportion;
}

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
public class CardCResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("month")
    private Long month;
    @JsonProperty("intoxicated")
    private Long intoxicated;
}

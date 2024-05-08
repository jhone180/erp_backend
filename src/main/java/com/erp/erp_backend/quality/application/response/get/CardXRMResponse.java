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
public class CardXRMResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("hours")
    private Long hours;
    @JsonProperty("sample")
    private Long sample;
    @JsonProperty("weight")
    private Long weight;
    @JsonProperty("average")
    private double average;
    @JsonProperty("range")
    private double range;
}

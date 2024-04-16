package com.erp.erp_backend.quality.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class PostResponseGeneral {

    @JsonProperty("success")
    private boolean success;
    @JsonProperty("message")
    private String message;
}

package com.erp.erp_backend.quality.application.request.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateCardPRequest {

    @JsonProperty("id")
    @NotNull(message = "id is required")
    @Positive(message = "id must be greater than 0")
    private Long id;
    @JsonProperty("sample")
    private Long sample;
    @JsonProperty("lot_size")
    private Long lotSize;
    @JsonProperty("defective_items")
    private Long defectiveItems;
    @JsonProperty("proportion")
    private Double proportion;
    @JsonProperty("user_id")
    @NotNull(message = "user_id is required")
    @Positive(message = "id must be greater than 0")
    private Long userId;
}

package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardsXRMRequest {

    @Valid
    @NotNull(message = "The cards_xrm is required")
    @JsonProperty("cards_xrm")
    private List<SaveCardXRMRequest> cardsXRM;
    @NotNull(message = "The user_id is required")
    @JsonProperty("user_id")
    private Long userId;

}

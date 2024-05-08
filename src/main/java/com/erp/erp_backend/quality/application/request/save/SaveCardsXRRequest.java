package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardsXRRequest {

    @Valid
    @NotNull(message = "The cards_xr is required")
    @JsonProperty("cards_xr")
    private List<SaveCardXRRequest> cardsXR;
    @NotNull(message = "The user_id is required")
    @JsonProperty("user_id")
    private Long userId;
}

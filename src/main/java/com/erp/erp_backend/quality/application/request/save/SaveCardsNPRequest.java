package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardsNPRequest {

    @JsonProperty("cards_np")
    @Valid
    private List<SaveCardNPRequest> cardsNP;
    @JsonProperty("user_id")
    @NotNull(message = "user_id is required")
    private Long userId;
}

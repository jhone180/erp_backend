package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardsURequest {

    @JsonProperty("cards_u")
    @Valid
    private List<SaveCardURequest> cardsU;
    @JsonProperty("user_id")
    @NotNull(message = "user_id is required")
    @Positive(message = "id must be greater than 0")
    private Long userId;
}

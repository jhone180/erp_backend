package com.erp.erp_backend.quality.application.request.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SaveCardsPRequest {

    @JsonProperty("cards_p")
    @Valid
    private List<SaveCardPRequest> cardsP;
    @JsonProperty("user_id")
    @NotNull(message = "user_id is required")
    private Long userId;
}

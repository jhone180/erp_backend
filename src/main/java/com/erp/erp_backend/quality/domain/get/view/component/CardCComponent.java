package com.erp.erp_backend.quality.domain.get.view.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class CardCComponent {
    @JsonProperty("month")
    private Long month;
    @JsonProperty("intoxicated")
    private Long intoxicated;
}

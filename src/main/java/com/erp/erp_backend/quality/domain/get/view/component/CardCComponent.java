package com.erp.erp_backend.quality.domain.get.view.component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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

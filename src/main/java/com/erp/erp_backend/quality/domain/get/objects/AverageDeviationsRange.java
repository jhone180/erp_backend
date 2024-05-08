package com.erp.erp_backend.quality.domain.get.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AverageDeviationsRange {

        private Long id;
        private double average;
        private double deviations;
        private double range;
}

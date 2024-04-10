package com.erp.erp_backend.quality.application.exceptiondto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ExceptionDTO {

    private String message;

}

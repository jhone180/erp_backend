package com.erp.erp_backend.quality.exception;

import com.erp.erp_backend.quality.application.exceptiondto.ExceptionDTO;
import com.erp.erp_backend.quality.exception.exceptions.ObjectNullException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ObjectNullException.class)
    public ResponseEntity<?> objectNullException(ObjectNullException objectNullException){
        ExceptionDTO exceptionDTO = ExceptionDTO.builder()
                .message(objectNullException.getMessage())
                .build();
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

}

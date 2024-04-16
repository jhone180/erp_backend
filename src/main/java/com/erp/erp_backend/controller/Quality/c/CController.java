package com.erp.erp_backend.controller.Quality.c;

import com.erp.erp_backend.quality.application.request.save.SaveCardsCRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardCRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardC;
import com.erp.erp_backend.quality.domain.update.UpdateCardC;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/c")
@Validated
public class CController {

    private final SaveCardC saveCardC;

    private final UpdateCardC updateCardC;

    public CController(SaveCardC saveCardC,
                        UpdateCardC updateCardC) {
        this.saveCardC = saveCardC;
        this.updateCardC = updateCardC;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsCRequest saveCardsCRequest) {
        return new ResponseEntity<>(saveCardC.apply(saveCardsCRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardCRequest updateCardCRequest) {
        return new ResponseEntity<>(updateCardC.apply(updateCardCRequest), HttpStatus.OK);
    }
}

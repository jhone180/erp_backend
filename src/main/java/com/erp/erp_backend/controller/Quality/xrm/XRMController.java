package com.erp.erp_backend.controller.Quality.xrm;

import com.erp.erp_backend.quality.application.request.save.SaveCardsXRMRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardXRMRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardXRM;
import com.erp.erp_backend.quality.domain.update.UpdateCardXRM;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/xrm")
@Validated
public class XRMController {

    private final SaveCardXRM saveCardXRM;

    private final UpdateCardXRM updateCardXRM;

    public XRMController(SaveCardXRM saveCardXRM,
                             UpdateCardXRM updateCardXRM) {
        this.saveCardXRM = saveCardXRM;
        this.updateCardXRM = updateCardXRM;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsXRMRequest saveCardsXRMRequest) {
        return new ResponseEntity<>(saveCardXRM.apply(saveCardsXRMRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardXRMRequest updateCardXRMRequest) {
        return new ResponseEntity<>(updateCardXRM.apply(updateCardXRMRequest), HttpStatus.OK);
    }
}

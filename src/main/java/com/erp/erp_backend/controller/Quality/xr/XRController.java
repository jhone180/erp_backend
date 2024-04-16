package com.erp.erp_backend.controller.Quality.xr;

import com.erp.erp_backend.quality.application.request.save.SaveCardsXRRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardXRRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardXR;
import com.erp.erp_backend.quality.domain.update.UpdateCardXR;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/xr")
@Validated
public class XRController {

    private final SaveCardXR saveCardXR;

    private final UpdateCardXR updateCardXR;

    public XRController(SaveCardXR saveCardXR,
                         UpdateCardXR updateCardXR) {
        this.saveCardXR = saveCardXR;
        this.updateCardXR = updateCardXR;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsXRRequest saveCardsXRRequest) {
        return new ResponseEntity<>(saveCardXR.apply(saveCardsXRRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardXRRequest updateCardXRRequest) {
        return new ResponseEntity<>(updateCardXR.apply(updateCardXRRequest), HttpStatus.OK);
    }
}

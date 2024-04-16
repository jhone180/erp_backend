package com.erp.erp_backend.controller.Quality.xs;

import com.erp.erp_backend.quality.application.request.save.SaveCardsXSRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardXSRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardXS;
import com.erp.erp_backend.quality.domain.update.UpdateCardXS;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/xs")
@Validated
public class XSController {

    private final SaveCardXS saveCardXS;

    private final UpdateCardXS updateCardXS;

    public XSController(SaveCardXS saveCardXS,
                        UpdateCardXS updateCardXS) {
        this.saveCardXS = saveCardXS;
        this.updateCardXS = updateCardXS;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsXSRequest saveCardsXSRequest) {
        return new ResponseEntity<>(saveCardXS.apply(saveCardsXSRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardXSRequest updateCardXSRequest) {
        return new ResponseEntity<>(updateCardXS.apply(updateCardXSRequest), HttpStatus.OK);
    }
}

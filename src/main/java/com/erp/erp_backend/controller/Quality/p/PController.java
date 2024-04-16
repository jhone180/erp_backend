package com.erp.erp_backend.controller.Quality.p;

import com.erp.erp_backend.quality.application.request.save.SaveCardsPRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardPRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardP;
import com.erp.erp_backend.quality.domain.update.UpdateCardP;
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
public class PController {

    private final SaveCardP saveCardP;

    private final UpdateCardP updateCardP;

    public PController(SaveCardP saveCardP,
                       UpdateCardP updateCardP) {
        this.saveCardP = saveCardP;
        this.updateCardP = updateCardP;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsPRequest saveCardsPRequest) {
        return new ResponseEntity<>(saveCardP.apply(saveCardsPRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardPRequest updateCardPRequest) {
        return new ResponseEntity<>(updateCardP.apply(updateCardPRequest), HttpStatus.OK);
    }
}

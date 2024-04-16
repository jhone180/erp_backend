package com.erp.erp_backend.controller.Quality.np;

import com.erp.erp_backend.quality.application.request.save.SaveCardsNPRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardNPRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardNP;
import com.erp.erp_backend.quality.domain.update.UpdateCardNP;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/np")
@Validated
public class NPController {

    private final SaveCardNP saveCardNP;

    private final UpdateCardNP updateCardNP;

    public NPController(SaveCardNP saveCardNP,
                       UpdateCardNP updateCardNP) {
        this.saveCardNP = saveCardNP;
        this.updateCardNP = updateCardNP;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsNPRequest saveCardsNPRequest) {
        return new ResponseEntity<>(saveCardNP.apply(saveCardsNPRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardNPRequest updateCardNPRequest) {
        return new ResponseEntity<>(updateCardNP.apply(updateCardNPRequest), HttpStatus.OK);
    }
}

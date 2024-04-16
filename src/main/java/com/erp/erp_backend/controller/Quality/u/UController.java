package com.erp.erp_backend.controller.Quality.u;

import com.erp.erp_backend.quality.application.request.save.SaveCardsURequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardURequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.domain.save.SaveCardU;
import com.erp.erp_backend.quality.domain.update.UpdateCardU;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/u")
@Validated
public class UController {

    private final SaveCardU saveCardU;

    private final UpdateCardU updateCardU;

    public UController(SaveCardU saveCardU,
                       UpdateCardU updateCardU) {
        this.saveCardU = saveCardU;
        this.updateCardU = updateCardU;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsURequest saveCardsURequest) {
        return new ResponseEntity<>(saveCardU.apply(saveCardsURequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardURequest updateCardURequest) {
        return new ResponseEntity<>(updateCardU.apply(updateCardURequest), HttpStatus.OK);
    }
}

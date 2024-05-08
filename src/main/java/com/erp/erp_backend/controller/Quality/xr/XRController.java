package com.erp.erp_backend.controller.Quality.xr;

import com.erp.erp_backend.quality.application.request.save.SaveCardsXRRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardXRRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.application.response.get.CardXRResponse;
import com.erp.erp_backend.quality.domain.delete.DeleteCardXR;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardXRComponent;
import com.erp.erp_backend.quality.domain.save.SaveCardXR;
import com.erp.erp_backend.quality.domain.update.UpdateCardXR;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality/xr")
@Validated
public class XRController {

    private final SaveCardXR saveCardXR;

    private final UpdateCardXR updateCardXR;

    private final DeleteCardXR deleteCardXR;

    private final BuildCardXRComponent buildCardXRComponent;

    public XRController(SaveCardXR saveCardXR,
                         UpdateCardXR updateCardXR,
                         BuildCardXRComponent buildCardXRComponent,
                        DeleteCardXR deleteCardXR) {
        this.saveCardXR = saveCardXR;
        this.updateCardXR = updateCardXR;
        this.buildCardXRComponent = buildCardXRComponent;
        this.deleteCardXR = deleteCardXR;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsXRRequest saveCardsXRRequest) {
        return new ResponseEntity<>(saveCardXR.apply(saveCardsXRRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardXRRequest updateCardXRRequest) {
        return new ResponseEntity<>(updateCardXR.apply(updateCardXRRequest), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CardXRResponse>> getAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(buildCardXRComponent.apply(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<PostResponseGeneral> deleteAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(deleteCardXR.apply(userId), HttpStatus.OK);
    }
}

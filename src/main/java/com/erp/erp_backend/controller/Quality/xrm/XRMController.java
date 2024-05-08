package com.erp.erp_backend.controller.Quality.xrm;

import com.erp.erp_backend.quality.application.request.save.SaveCardsXRMRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardXRMRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.application.response.get.CardXRMResponse;
import com.erp.erp_backend.quality.domain.delete.DeleteCardXRM;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardXRMComponent;
import com.erp.erp_backend.quality.domain.save.SaveCardXRM;
import com.erp.erp_backend.quality.domain.update.UpdateCardXRM;
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
@RequestMapping("/quality/xrm")
@Validated
public class XRMController {

    private final SaveCardXRM saveCardXRM;

    private final UpdateCardXRM updateCardXRM;

    private final DeleteCardXRM deleteCardXRM;

    private final BuildCardXRMComponent buildCardXRMComponent;

    public XRMController(SaveCardXRM saveCardXRM,
                             UpdateCardXRM updateCardXRM,
                             DeleteCardXRM deleteCardXRM,
                             BuildCardXRMComponent buildCardXRMComponent) {
        this.saveCardXRM = saveCardXRM;
        this.updateCardXRM = updateCardXRM;
        this.deleteCardXRM = deleteCardXRM;
        this.buildCardXRMComponent = buildCardXRMComponent;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsXRMRequest saveCardsXRMRequest) {
        return new ResponseEntity<>(saveCardXRM.apply(saveCardsXRMRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardXRMRequest updateCardXRMRequest) {
        return new ResponseEntity<>(updateCardXRM.apply(updateCardXRMRequest), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CardXRMResponse>> getAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(buildCardXRMComponent.apply(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<PostResponseGeneral> deleteAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(deleteCardXRM.apply(userId), HttpStatus.OK);
    }
}

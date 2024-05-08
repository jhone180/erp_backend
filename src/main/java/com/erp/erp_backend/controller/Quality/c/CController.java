package com.erp.erp_backend.controller.Quality.c;

import com.erp.erp_backend.quality.application.request.save.SaveCardsCRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardCRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.application.response.get.CardCResponse;
import com.erp.erp_backend.quality.domain.delete.DeleteCardC;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardCComponent;
import com.erp.erp_backend.quality.domain.save.SaveCardC;
import com.erp.erp_backend.quality.domain.update.UpdateCardC;
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
@RequestMapping("/quality/c")
@Validated
public class CController {

    private final SaveCardC saveCardC;

    private final UpdateCardC updateCardC;

    private final DeleteCardC deleteCardC;

    private final BuildCardCComponent buildCardCComponent;

    public CController(SaveCardC saveCardC,
                        UpdateCardC updateCardC,
                        DeleteCardC deleteCardC,
                        BuildCardCComponent buildCardCComponent) {
        this.saveCardC = saveCardC;
        this.updateCardC = updateCardC;
        this.deleteCardC = deleteCardC;
        this.buildCardCComponent = buildCardCComponent;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsCRequest saveCardsCRequest) {
        return new ResponseEntity<>(saveCardC.apply(saveCardsCRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardCRequest updateCardCRequest) {
        return new ResponseEntity<>(updateCardC.apply(updateCardCRequest), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CardCResponse>> getAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(buildCardCComponent.apply(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<PostResponseGeneral> deleteAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(deleteCardC.apply(userId), HttpStatus.OK);
    }
}

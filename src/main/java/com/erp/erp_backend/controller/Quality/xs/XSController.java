package com.erp.erp_backend.controller.Quality.xs;

import com.erp.erp_backend.quality.application.request.save.SaveCardsXSRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardXSRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.application.response.get.CardXSResponse;
import com.erp.erp_backend.quality.domain.delete.DeleteCardXS;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardXSComponent;
import com.erp.erp_backend.quality.domain.save.SaveCardXS;
import com.erp.erp_backend.quality.domain.update.UpdateCardXS;
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
@RequestMapping("/quality/xs")
@Validated
public class XSController {

    private final SaveCardXS saveCardXS;

    private final UpdateCardXS updateCardXS;

    private final DeleteCardXS deleteCardXS;

    private final BuildCardXSComponent buildCardXSComponent;

    public XSController(SaveCardXS saveCardXS,
                        UpdateCardXS updateCardXS,
                        DeleteCardXS deleteCardXS,
                        BuildCardXSComponent buildCardXSComponent) {
        this.saveCardXS = saveCardXS;
        this.updateCardXS = updateCardXS;
        this.deleteCardXS = deleteCardXS;
        this.buildCardXSComponent = buildCardXSComponent;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsXSRequest saveCardsXSRequest) {
        return new ResponseEntity<>(saveCardXS.apply(saveCardsXSRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardXSRequest updateCardXSRequest) {
        return new ResponseEntity<>(updateCardXS.apply(updateCardXSRequest), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CardXSResponse>> getAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(buildCardXSComponent.apply(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<PostResponseGeneral> deleteAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(deleteCardXS.apply(userId), HttpStatus.OK);
    }
}

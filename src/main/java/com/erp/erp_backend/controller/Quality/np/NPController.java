package com.erp.erp_backend.controller.Quality.np;

import com.erp.erp_backend.quality.application.request.save.SaveCardsNPRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardNPRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.application.response.get.CardNPResponse;
import com.erp.erp_backend.quality.domain.delete.DeleteCardNP;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardNPComponent;
import com.erp.erp_backend.quality.domain.save.SaveCardNP;
import com.erp.erp_backend.quality.domain.update.UpdateCardNP;
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
@RequestMapping("/quality/np")
@Validated
public class NPController {

    private final SaveCardNP saveCardNP;

    private final UpdateCardNP updateCardNP;

    private final DeleteCardNP deleteCardNP;

    private final BuildCardNPComponent buildCardNPComponent;

    public NPController(SaveCardNP saveCardNP,
                       UpdateCardNP updateCardNP,
                        DeleteCardNP deleteCardNP,
                        BuildCardNPComponent buildCardNPComponent) {
        this.saveCardNP = saveCardNP;
        this.updateCardNP = updateCardNP;
        this.deleteCardNP = deleteCardNP;
        this.buildCardNPComponent = buildCardNPComponent;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsNPRequest saveCardsNPRequest) {
        return new ResponseEntity<>(saveCardNP.apply(saveCardsNPRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardNPRequest updateCardNPRequest) {
        return new ResponseEntity<>(updateCardNP.apply(updateCardNPRequest), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CardNPResponse>> getAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(buildCardNPComponent.apply(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<PostResponseGeneral> deleteAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(deleteCardNP.apply(userId), HttpStatus.OK);
    }
}

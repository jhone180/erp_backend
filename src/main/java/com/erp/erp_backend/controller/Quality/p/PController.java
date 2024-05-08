package com.erp.erp_backend.controller.Quality.p;

import com.erp.erp_backend.quality.application.request.save.SaveCardsPRequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardPRequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.application.response.get.CardPResponse;
import com.erp.erp_backend.quality.domain.delete.DeleteCardP;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardPComponent;
import com.erp.erp_backend.quality.domain.save.SaveCardP;
import com.erp.erp_backend.quality.domain.update.UpdateCardP;
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
@RequestMapping("/quality/p")
@Validated
public class PController {

    private final SaveCardP saveCardP;

    private final UpdateCardP updateCardP;

    private final DeleteCardP deleteCardP;

    private final BuildCardPComponent buildCardPComponent;

    public PController(SaveCardP saveCardP,
                       UpdateCardP updateCardP,
                       DeleteCardP deleteCardP,
                       BuildCardPComponent buildCardPComponent) {
        this.saveCardP = saveCardP;
        this.updateCardP = updateCardP;
        this.deleteCardP = deleteCardP;
        this.buildCardPComponent = buildCardPComponent;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsPRequest saveCardsPRequest) {
        return new ResponseEntity<>(saveCardP.apply(saveCardsPRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardPRequest updateCardPRequest) {
        return new ResponseEntity<>(updateCardP.apply(updateCardPRequest), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CardPResponse>> getAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(buildCardPComponent.apply(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<PostResponseGeneral> deleteAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(deleteCardP.apply(userId), HttpStatus.OK);
    }
}

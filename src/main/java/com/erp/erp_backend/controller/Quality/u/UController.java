package com.erp.erp_backend.controller.Quality.u;

import com.erp.erp_backend.quality.application.request.save.SaveCardsURequest;
import com.erp.erp_backend.quality.application.request.update.UpdateCardURequest;
import com.erp.erp_backend.quality.application.response.PostResponseGeneral;
import com.erp.erp_backend.quality.application.response.get.CardUResponse;
import com.erp.erp_backend.quality.domain.delete.DeleteCardU;
import com.erp.erp_backend.quality.domain.get.view.form.BuildCardUComponent;
import com.erp.erp_backend.quality.domain.save.SaveCardU;
import com.erp.erp_backend.quality.domain.update.UpdateCardU;
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
@RequestMapping("/quality/u")
@Validated
public class UController {

    private final SaveCardU saveCardU;

    private final UpdateCardU updateCardU;

    private final DeleteCardU deleteCardU;

    private final BuildCardUComponent buildCardUComponent;

    public UController(SaveCardU saveCardU,
                       UpdateCardU updateCardU,
                       DeleteCardU deleteCardU,
                       BuildCardUComponent buildCardUComponent) {
        this.saveCardU = saveCardU;
        this.updateCardU = updateCardU;
        this.deleteCardU = deleteCardU;
        this.buildCardUComponent = buildCardUComponent;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<PostResponseGeneral> saveAll(@Valid @RequestBody SaveCardsURequest saveCardsURequest) {
        return new ResponseEntity<>(saveCardU.apply(saveCardsURequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PostResponseGeneral> update(@Valid @RequestBody UpdateCardURequest updateCardURequest) {
        return new ResponseEntity<>(updateCardU.apply(updateCardURequest), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CardUResponse>> getAll(@RequestParam @NotNull Long userId){
        return new ResponseEntity<>(buildCardUComponent.apply(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<PostResponseGeneral> deleteAll(@RequestParam @NotNull Long userId) {
        return new ResponseEntity<>(deleteCardU.apply(userId), HttpStatus.OK);
    }
}

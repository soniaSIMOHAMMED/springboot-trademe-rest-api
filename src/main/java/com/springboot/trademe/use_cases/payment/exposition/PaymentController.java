package com.springboot.trademe.use_cases.payment.exposition;

import com.springboot.trademe.kernel.CommandBus;
import com.springboot.trademe.kernel.QueryBus;
import com.springboot.trademe.use_cases.payment.application.PaymentPerMonthProcess;
import com.springboot.trademe.use_cases.project.application.create.CreateProject;
import com.springboot.trademe.use_cases.project.exposition.ProjectDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;


    public PaymentController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(path = "/creditcard/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> makePayment(@Valid @RequestBody CreditCardDTO creditCardDTO, @PathVariable("id") Long userId) {
        PaymentPerMonthProcess paymentPerMonthProcess = PaymentPerMonthProcess.of(userId,creditCardDTO.getName(),creditCardDTO.getCardNumber(),creditCardDTO.getCvv(),creditCardDTO.getExpiryDate());
        String name = commandBus.send(paymentPerMonthProcess);
        return ResponseEntity.created(URI.create("/creditcard/" + name)).build();
    }

    @PostMapping(path = "/paypal/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> makePayment(@Valid @RequestBody PayPalDTO payPalDTO, @PathVariable("id") Long userId) {
        PaymentPerMonthProcess paymentPerMonthProcess = PaymentPerMonthProcess.of(userId,payPalDTO.getEmail(),payPalDTO.getPassword());
        String name = commandBus.send(paymentPerMonthProcess);
        return ResponseEntity.created(URI.create("/paypal/" + name)).build();
    }


}

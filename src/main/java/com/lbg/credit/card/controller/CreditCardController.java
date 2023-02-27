package com.lbg.credit.card.controller;

import com.lbg.credit.card.dto.Account;
import com.lbg.credit.card.dto.AccountResponse;
import com.lbg.credit.card.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CreditCardController {
    private final Logger logger = Logger.getLogger(CreditCardController.class.getName());

    @Autowired
    private CreditCardService creditCardService;

    @RequestMapping(value= "/addAccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponse addAccount(@RequestBody Account account){
        logger.info("Request is received");
        AccountResponse accountResponse = creditCardService.addAccount(account);
        return accountResponse;
    }
}

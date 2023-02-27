package com.lbg.credit.card.service;

import com.lbg.credit.card.dto.Account;
import com.lbg.credit.card.dto.AccountResponse;

public interface CreditCardService {

    AccountResponse addAccount(Account account);
}

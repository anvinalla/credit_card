package com.lbg.credit.card.service.impl;

import com.lbg.credit.card.dto.Account;
import com.lbg.credit.card.dto.AccountResponse;
import com.lbg.credit.card.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final Logger logger = Logger.getLogger(CreditCardServiceImpl.class.getName());

    @Override
    public AccountResponse addAccount(Account account) {
        boolean accountStatus = false;
        if (account.getSrcCode().length() == 6 && account.getAccNo().length() == 8 && !account.getAccNo().startsWith("8")){
            accountStatus = true;
            logger.info("Status is true");
        }

        var accountResponse = AccountResponse.builder()
                .name(account.getName())
                .status(accountStatus)
                .pan(maskPan(account.getPan()))
                .build();
        logger.info("AccountResponse is mapped");
        return accountResponse;
    }

    public String maskPan(String pan){
        if(pan == null){
            return null;
        }
        int maskLength = pan.length();
        logger.info("PAN length: " + maskLength);
        StringBuilder strPan = new StringBuilder();
        for(int i=4; i< maskLength-4; i++){
            strPan.append("x");
        }

        return pan.substring(0, 4) + strPan.toString() + pan.substring( maskLength -4);
    }
}

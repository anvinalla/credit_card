package com.lbg.credit.card;

import com.lbg.credit.card.dto.Account;
import com.lbg.credit.card.dto.AccountResponse;

import com.lbg.credit.card.service.impl.CreditCardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CreditCardServiceImplTest {

    @InjectMocks
    CreditCardServiceImpl service;

    @Test
    void addAccount_status_true() {
        // Given
        var account = Account.builder()
                        .name("TestUser")
                        .accNo("12345678")
                        .srcCode("121212")
                        .pan("1234123412340980")
                .build();

        var accountResponse = AccountResponse.builder()
                .name("TestUser")
                .status(true)
                .pan("1234xxxxxxxx0980")
                .build();
        // When
       AccountResponse result = service.addAccount(account);

        // Then
        assertThat(result).isEqualTo(accountResponse);
    }

    @Test
    void addAccount_status_false_when_srcCode_length_is_less_than_6() {
        // Given
        var account = Account.builder()
                .name("TestUser")
                .accNo("12345678")
                .srcCode("1212")
                .pan("1234123412340980")
                .build();

        var accountResponse = AccountResponse.builder()
                .name("TestUser")
                .status(false)
                .pan("1234xxxxxxxx0980")
                .build();
        // When
        AccountResponse result = service.addAccount(account);

        // Then
        assertThat(result).isEqualTo(accountResponse);
    }

    @Test
    void addAccount_status_false_when_accNo_length_is_less_than_8() {
        // Given
        var account = Account.builder()
                .name("TestUser")
                .accNo("1234567")
                .srcCode("121212")
                .pan("1234123412340980")
                .build();

        var accountResponse = AccountResponse.builder()
                .name("TestUser")
                .status(false)
                .pan("1234xxxxxxxx0980")
                .build();
        // When
        AccountResponse result = service.addAccount(account);

        // Then
        assertThat(result).isEqualTo(accountResponse);
    }

    @Test
    void addAccount_status_false_when_accNo_length_starts_with_8() {
        // Given
        var account = Account.builder()
                .name("TestUser")
                .accNo("81234567")
                .srcCode("121212")
                .pan("1234123412340980")
                .build();

        var accountResponse = AccountResponse.builder()
                .name("TestUser")
                .status(false)
                .pan("1234xxxxxxxx0980")
                .build();
        // When
        AccountResponse result = service.addAccount(account);

        // Then
        assertThat(result).isEqualTo(accountResponse);
    }

    @Test
    void mask_pan_when_string_is_present(){
        //given
        var pan = "1234123412340980";
        var maskedPan = "1234xxxxxxxx0980";

        //when
        String result = service.maskPan(pan);

        //then
        assertThat(result).isEqualTo(maskedPan);
    }

}

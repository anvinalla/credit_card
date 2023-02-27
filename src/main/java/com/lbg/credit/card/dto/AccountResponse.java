package com.lbg.credit.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AccountResponse {

    private String name;
    private boolean status;
    @JsonProperty("PAN")
    private String pan;
}

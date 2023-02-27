package com.lbg.credit.card.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class Account {

private String name;
private String accNo;
private String srcCode;
@JsonProperty("PAN")
private String pan;

}

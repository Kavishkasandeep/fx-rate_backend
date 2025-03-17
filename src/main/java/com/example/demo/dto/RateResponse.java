package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RateResponse {
    private String exCode;
    private String description;
    private String code;
    private Cheques cheques;
    private Currency currency;
    private TelegraphicTransfers telegraphicTransfers;
}


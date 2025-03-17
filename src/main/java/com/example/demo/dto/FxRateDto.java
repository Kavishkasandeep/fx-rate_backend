package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FxRateDto {
    private Long id;
    private String date;
    private String exCode;
    private String description;
    private String code;
    private String currency;
    private double sellingRate;
    private double buyingRate;
}

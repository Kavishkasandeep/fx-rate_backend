package com.example.demo.service;

import com.example.demo.dto.FxRateDto;
import com.example.demo.dto.MsgResponse;

public interface FxRateService {
    MsgResponse getAllRates();

     void addRate(FxRateDto fxRateDto);

    String updateRate( FxRateDto fxRateDto);

    boolean isRateExist(Long id);

    String fxRateDelete(long id);
}

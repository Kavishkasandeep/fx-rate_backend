package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.FxRateEntity;
import com.example.demo.repository.FxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FxRateServiceImpl implements FxRateService {
    @Autowired
    private FxRateRepository fxRateRepository;

    public MsgResponse getAllRates() {
        MsgResponse msgResponse = new MsgResponse();
        Data data = new Data();


        msgResponse.setMESSAGE("EXCHANGE_RATES_RETRIEVE_SUCCESS");
        msgResponse.setSTATUS("SUCCESS");
        data.setDate(LocalDate.now().toString());
        msgResponse.setData(data);

        List<FxRateEntity> fxRateList = fxRateRepository.findAll();

        List<Rates> ratesList = new ArrayList<>();

        for (FxRateEntity fxRate : fxRateList) {
            Rates rates = new Rates();
            Cheques cheques = new Cheques();
            Currency currency = new Currency();
            TelegraphicTransfers telegraphicTransfers = new TelegraphicTransfers();


            RateResponse rateResponse = new RateResponse();
            rateResponse.setExCode(fxRate.getExCode());
            rateResponse.setDescription(fxRate.getDescription());
            rateResponse.setCode(fxRate.getCode());

            cheques.setBuying_rate(fxRate.getBuyingRate());
            cheques.setSelling_rate(fxRate.getSellingRate());
            rateResponse.setCheques(cheques);

            currency.setBuying_rate(fxRate.getBuyingRate());
            currency.setSelling_rate(fxRate.getSellingRate());
            rateResponse.setCurrency(currency);


            telegraphicTransfers.setBuying_rate(fxRate.getBuyingRate());
            telegraphicTransfers.setSelling_rate(fxRate.getSellingRate());
            rateResponse.setTelegraphicTransfers(telegraphicTransfers);
            rates.setRate(rateResponse);
            rates.setDate(fxRate.getDate());
            ratesList.add(rates);

        }
        data.setRates(ratesList);
        return msgResponse;
    }


    @Override
    public void addRate(FxRateDto fxRateDto) {
        FxRateEntity fxRateEntity=new FxRateEntity();
        fxRateEntity.setDate(fxRateDto.getDate());
        fxRateEntity.setExCode(fxRateDto.getExCode());
        fxRateEntity.setCurrency(fxRateDto.getCurrency());
        fxRateEntity.setDescription(fxRateDto.getDescription());
        fxRateEntity.setCode(fxRateDto.getCode());
        fxRateEntity.setBuyingRate(fxRateDto.getBuyingRate());
        fxRateEntity.setSellingRate(fxRateDto.getSellingRate());


        fxRateRepository.save(fxRateEntity);

    }

    @Override
    public String updateRate(FxRateDto fxRateDto) {
        Optional<FxRateEntity> existingRateOpt = fxRateRepository.findById(fxRateDto.getId());

        if (existingRateOpt.isEmpty()) {
            return "Rate does not exist";
        }

        FxRateEntity fxRateEntity = existingRateOpt.get();
        fxRateEntity.setDate(fxRateDto.getDate());
        fxRateEntity.setExCode(fxRateDto.getExCode());
        fxRateEntity.setCurrency(fxRateDto.getCurrency());
        fxRateEntity.setDescription(fxRateDto.getDescription());
        fxRateEntity.setCode(fxRateDto.getCode());
        fxRateEntity.setBuyingRate(fxRateDto.getBuyingRate());
        fxRateEntity.setSellingRate(fxRateDto.getSellingRate());

        fxRateRepository.save(fxRateEntity);
        return "Update successful";
    }


    @Override
    public boolean isRateExist(Long id) {
        return fxRateRepository.existsById(id);
    }

    @Override
    public String fxRateDelete(long id) {
        fxRateRepository.deleteById(id);
        return "Delete success";
    }

}

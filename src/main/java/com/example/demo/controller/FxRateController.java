package com.example.demo.controller;


import com.example.demo.dto.FxRateDto;
import com.example.demo.dto.MsgResponse;
import com.example.demo.service.FxRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fx_rate")
public class FxRateController {
    @Autowired
    private FxRateService fxRateService;


    @GetMapping
    public MsgResponse getAllRates() {
        return fxRateService.getAllRates();
    }

    @PostMapping
    public String addRate(@RequestBody FxRateDto fxRateDto) {
        fxRateService.addRate(fxRateDto);
        return "Saved Successfully";
    }

    @PutMapping
    public ResponseEntity<String> updateRate(@RequestBody FxRateDto fxRateDto) {
        if (!fxRateService.isRateExist(fxRateDto.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rate does not exist");
        }
        fxRateService.updateRate(fxRateDto);
        return ResponseEntity.ok("Update successful");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRate(@PathVariable long id) {
        if (!fxRateService.isRateExist(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rate does not exist");
        }
        fxRateService.fxRateDelete(id);
        return ResponseEntity.ok("Delete successful");
    }

}

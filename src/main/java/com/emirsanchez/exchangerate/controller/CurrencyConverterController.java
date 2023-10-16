package com.emirsanchez.exchangerate.controller;

import com.emirsanchez.exchangerate.entity.dto.ExchangeRateDTO;
import com.emirsanchez.exchangerate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author: E. Sanchez R.
 * @createdAt: 16/10/2023
 */
@RestController
@RequestMapping("/api/v1/currency-converter")
public class CurrencyConverterController {

    @Autowired
    private ExchangeRateService exchangeService;

    @GetMapping(value = "/currency")
    public ResponseEntity<Optional<ExchangeRateDTO.Response>>  getExchange(@RequestBody ExchangeRateDTO.Request request) {
        return ResponseEntity.ok(Optional.ofNullable(exchangeService.getExchange(request)));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ExchangeRateDTO.Exchange>> getAll() {
//        return ResponseEntity.ok(Optional.ofNullable(exchangeService.findAll()));
        List<ExchangeRateDTO.Exchange> allExchangeRates = exchangeService.findAll();
        return ResponseEntity.ok(allExchangeRates);
    }

    @PutMapping(value = "/update/{id}/{exchangeType}")
    public ResponseEntity<Optional<ExchangeRateDTO.Exchange>> updateExchangeRate(@PathVariable(name = "id") Integer id,
                                                                                 @PathVariable(name = "exchangeType") Double exchangeType) {
        return ResponseEntity.ok(Optional.ofNullable(exchangeService.updateById(exchangeType, id)));
    }

    /*@PutMapping(value = "/update")
    public ResponseEntity<Optional<ExchangeRateDTO.Exchange>> updateExchangeRate(@RequestBody ExchangeRateDTO.Exchange exchange) {
        return ResponseEntity.ok(Optional.ofNullable(exchangeService.updateExchangeRate(exchange)));
    }*/

    @PutMapping("/update-rate")
    public ResponseEntity<ExchangeRateDTO.Exchange> updateRate(@RequestBody ExchangeRateDTO.Exchange exchangeRateDTO) {
        ExchangeRateDTO.Exchange updatedExchangeRate = exchangeService.updateExchangeRate(exchangeRateDTO);
        return ResponseEntity.ok(updatedExchangeRate);
    }

}

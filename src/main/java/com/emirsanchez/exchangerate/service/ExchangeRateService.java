package com.emirsanchez.exchangerate.service;

import com.emirsanchez.exchangerate.entity.dto.ExchangeRateDTO;

import java.util.List;

/**
 * @author: E. Sanchez R.
 * @createdAt: 16/10/2023
 */
public interface ExchangeRateService {

    ExchangeRateDTO.Response getExchange(ExchangeRateDTO.Request request);
    List<ExchangeRateDTO.Exchange> findAll();
    ExchangeRateDTO.Exchange updateById(Double exchangeType, Integer id);
    ExchangeRateDTO.Exchange updateExchangeRate(ExchangeRateDTO.Exchange exchange);

}

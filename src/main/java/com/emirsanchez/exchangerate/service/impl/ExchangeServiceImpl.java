package com.emirsanchez.exchangerate.service.impl;

import com.emirsanchez.exchangerate.entity.ExchangeRate;
import com.emirsanchez.exchangerate.entity.dto.ExchangeRateDTO;
import com.emirsanchez.exchangerate.entity.mappers.ExchangeRateMapper;
import com.emirsanchez.exchangerate.repository.ExchangeRateRepository;
import com.emirsanchez.exchangerate.service.ExchangeRateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: E. Sanchez R.
 * @createdAt: 16/10/2023
 */
@Service
@Transactional
public class ExchangeServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRepository;


    @Override
    public ExchangeRateDTO.Response getExchange(ExchangeRateDTO.Request request) {
        ExchangeRateDTO.Response response = new ExchangeRateDTO.Response();
        Optional<ExchangeRate> exchangeEntityOptional = exchangeRepository.findTopByBaseCurrencyAndFinalCurrency(request.getOriginCurrency(), request.getFinalCurrency());

        if (exchangeEntityOptional.isPresent()) {
            ExchangeRate exchangeEntity = exchangeEntityOptional.get();
            response.setInitialAmount(request.getAmount());
            response.setFinalAmount(request.getAmount() * exchangeEntity.getExchangeType());
            response.setBaseCurrency(exchangeEntity.getBaseCurrency());
            response.setFinalCurrency(exchangeEntity.getFinalCurrency());
            response.setExchangeType(exchangeEntity.getExchangeType());

            return response;
        }

        return null;
    }

    @Override
    public List<ExchangeRateDTO.Exchange> findAll() {
        List <ExchangeRate> entityList = exchangeRepository.findAll();
        List <ExchangeRateDTO.Exchange> exchangeList = new ArrayList<>();

        for (ExchangeRate exchangeEntity: entityList){
            exchangeList.add(ExchangeRateMapper.INSTANCE.toDto(exchangeEntity));
        }

        return exchangeList;
    }

    @Override
    public ExchangeRateDTO.Exchange updateById(Double exchangeType, Integer id) {
        Integer result = exchangeRepository.setExchangeTypeById(exchangeType, id);
        Optional<ExchangeRate> exchangeEntity = exchangeRepository.findById(id);

        return (result > 0 && exchangeEntity.isPresent() ? ExchangeRateMapper.INSTANCE.toDto(exchangeEntity.get()) : null );

    }

    @Override
    public ExchangeRateDTO.Exchange updateExchangeRate(ExchangeRateDTO.Exchange exchange) {
        Integer result = exchangeRepository.setExchangeTypeByBaseCurrencyAndFinalCurrency(exchange.getExchangeType(),
                exchange.getBaseCurrency(),
                exchange.getFinalCurrency());
        Optional<ExchangeRate> exchangeEntity = exchangeRepository.findTopByBaseCurrencyAndFinalCurrency(exchange.getBaseCurrency(), exchange.getFinalCurrency());

        return (result > 0 && exchangeEntity.isPresent() ? ExchangeRateMapper.INSTANCE.toDto(exchangeEntity.get()) : null );

    }
}

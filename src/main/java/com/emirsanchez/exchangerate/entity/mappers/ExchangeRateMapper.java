package com.emirsanchez.exchangerate.entity.mappers;

import com.emirsanchez.exchangerate.entity.ExchangeRate;
import com.emirsanchez.exchangerate.entity.dto.ExchangeRateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author: E. Sanchez R.
 * @createdAt: 16/10/2023
 */
@Mapper
public interface ExchangeRateMapper {
    ExchangeRateMapper INSTANCE = Mappers.getMapper(ExchangeRateMapper.class);

    ExchangeRateDTO.Exchange toDto(ExchangeRate exchangeEntity);
}

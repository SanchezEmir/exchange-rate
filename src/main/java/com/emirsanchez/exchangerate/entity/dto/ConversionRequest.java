package com.emirsanchez.exchangerate.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: E. Sanchez R.
 * @createdAt: 16/10/2023
 */
@Data
public class ConversionRequest {

    private BigDecimal amount;
    private String sourceCurrency;
    private String targetCurrency;

}

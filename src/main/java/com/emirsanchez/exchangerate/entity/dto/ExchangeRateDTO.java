package com.emirsanchez.exchangerate.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: E. Sanchez R.
 * @createdAt: 16/10/2023
 */

public interface  ExchangeRateDTO {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Exchange {
        private Integer id;
        private String baseCurrency;
        private String finalCurrency;
        private Double exchangeType;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Request {
        private Double amount;
        private String originCurrency;
        private String finalCurrency;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Response {
        private Double InitialAmount;
        private Double finalAmount;

        private String baseCurrency;
        private String finalCurrency;
        private Double exchangeType;
    }

}

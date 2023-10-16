package com.emirsanchez.exchangerate.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: E. Sanchez R.
 * @createdAt: 16/10/2023
 */
@Entity
@Data
@Table(name = "exchanges")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="base_currency")
    private String baseCurrency;
    @Column(name="final_currency")
    private String finalCurrency;
    @Column(name="exchange_type")
    private Double exchangeType;

}

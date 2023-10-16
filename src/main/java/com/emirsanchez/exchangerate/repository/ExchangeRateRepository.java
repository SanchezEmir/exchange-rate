package com.emirsanchez.exchangerate.repository;

import com.emirsanchez.exchangerate.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author: E. Sanchez R.
 * @createdAt: 16/10/2023
 */
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {

    Optional<ExchangeRate> findTopByBaseCurrencyAndFinalCurrency(String baseCurrency, String finalCurrency);
    @Modifying
    @Query("UPDATE ExchangeRate ee SET ee.exchangeType = ?1 WHERE ee.baseCurrency = ?2 AND ee.finalCurrency = ?3")
    Integer setExchangeTypeByByBaseCurrencyAndFinalCurrency(Double exchangeType, String baseCurrency, String finalCurrency);

    @Modifying
    @Query("UPDATE ExchangeRate ee SET ee.exchangeType = ?1 where ee.id = ?2")
    Integer setExchangeTypeById(Double exchangeType, Integer id);
}

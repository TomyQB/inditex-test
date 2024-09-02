package com.inditex.inditex_test.domain.model;

import java.sql.Timestamp;

import com.inditex.inditex_test.domain.model.enums.CurrencyEnum;

import lombok.Builder;

@Builder
public record Price(long id, long brandId, Timestamp startDate, Timestamp endDate, int priceList,
                    long productId, int priority, double price, CurrencyEnum curr) {

}

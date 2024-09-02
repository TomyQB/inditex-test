package com.inditex.inditex_test.infraestructure.dto;

import lombok.Builder;

@Builder
public record GetPriceResponseDto(long productId, long brandId, int priceList, String startDate, String endDate, double price) {

}

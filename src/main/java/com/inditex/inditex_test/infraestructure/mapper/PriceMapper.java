package com.inditex.inditex_test.infraestructure.mapper;

import com.inditex.inditex_test.domain.model.Price;
import com.inditex.inditex_test.infraestructure.dto.GetPriceResponseDto;
import com.inditex.inditex_test.infraestructure.repository.entity.PriceEntity;
import com.inditex.inditex_test.infraestructure.util.DateUtil;

import org.springframework.stereotype.Service;

@Service
public class PriceMapper {

  public Price entityToDomain(final PriceEntity entity) {
    return Price.builder()
        .productId(entity.getProductId())
        .brandId(entity.getBrandId())
        .priceList(entity.getPriceList())
        .startDate(entity.getStartDate())
        .endDate(entity.getEndDate())
        .price(entity.getPrice())
        .build();
  }

  public GetPriceResponseDto domainToResponse(final Price domain) {
    return GetPriceResponseDto.builder()
        .productId(domain.productId())
        .brandId(domain.brandId())
        .priceList(domain.priceList())
        .startDate(DateUtil.timestampToString(domain.startDate()))
        .endDate(DateUtil.timestampToString(domain.endDate()))
        .price(domain.price())
        .build();
  }
}

package com.inditex.inditex_test.infraestructure.service;

import java.util.List;

import com.inditex.inditex_test.application.service.PriceService;
import com.inditex.inditex_test.domain.model.Price;
import com.inditex.inditex_test.infraestructure.repository.entity.PriceEntity;
import com.inditex.inditex_test.infraestructure.mapper.PriceMapper;
import com.inditex.inditex_test.infraestructure.repository.PriceRepository;
import com.inditex.inditex_test.infraestructure.util.DateUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PriceRepository priceRepository;

  private final PriceMapper priceMapper;

  @Override
  public Price getPrice(final long productId, final long brandId, final String date) {
    final PriceEntity price = priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, DateUtil.stringToTimestamp(date));
    return priceMapper.entityToDomain(price);
  }

}

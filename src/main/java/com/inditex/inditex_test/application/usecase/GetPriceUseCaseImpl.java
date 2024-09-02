package com.inditex.inditex_test.application.usecase;

import com.inditex.inditex_test.application.service.PriceService;
import com.inditex.inditex_test.domain.model.Price;
import com.inditex.inditex_test.domain.usecase.GetPriceUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPriceUseCaseImpl implements GetPriceUseCase {

  private final PriceService priceService;

  @Override
  public Price getPrice(final long productId, final long brandId, final String date) {
    return priceService.getPrice(productId, brandId, date);
  }
}

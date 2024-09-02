package com.inditex.inditex_test.application.service;

import com.inditex.inditex_test.domain.model.Price;

public interface PriceService {

  Price getPrice(final long productId, final long brandId, final String date);

}

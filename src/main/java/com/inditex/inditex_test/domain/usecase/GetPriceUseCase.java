package com.inditex.inditex_test.domain.usecase;

import com.inditex.inditex_test.domain.model.Price;

public interface GetPriceUseCase {

    Price getPrice(final long productId, final long brandId, final String date);

}

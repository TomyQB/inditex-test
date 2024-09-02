package com.inditex.inditex_test.infraestructure.controller;

import com.inditex.inditex_test.domain.model.Price;
import com.inditex.inditex_test.domain.usecase.GetPriceUseCase;
import com.inditex.inditex_test.infraestructure.dto.GetPriceResponseDto;
import com.inditex.inditex_test.infraestructure.mapper.PriceMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PriceController {

    private final GetPriceUseCase getPriceUsecase;

    private final PriceMapper priceMapper;

    @GetMapping("/prices")
    public GetPriceResponseDto getPrice(@RequestParam final long productId, @RequestParam final long brandId,
            @RequestParam final String date) {
        final Price price = getPriceUsecase.getPrice(productId, brandId, date);
        return priceMapper.domainToResponse(price);
    }

}

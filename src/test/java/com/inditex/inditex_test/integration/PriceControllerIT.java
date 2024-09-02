package com.inditex.inditex_test.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import com.inditex.inditex_test.infraestructure.dto.GetPriceResponseDto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerIT {

  @Autowired
  private TestRestTemplate restTemplate;

  private final ObjectMapper objectMapper;

  public PriceControllerIT() {
    this.objectMapper = new ObjectMapper();
  }

  @SneakyThrows
  @ParameterizedTest
  @MethodSource("generateData")
  void getPricesTest(final String path, final GetPriceResponseDto expected) {
    final ResponseEntity<String> response = restTemplate.getForEntity(path, String.class);

    final GetPriceResponseDto objectResponse =
        objectMapper.readValue(response.getBody(), new TypeReference<>() {
        });

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertEquals(objectResponse, expected);
  }

  private static Stream<Arguments> generateData() {
    return Stream.of(
        Arguments.of("/api/v1/prices?productId=35455&brandId=1&date=2020-06-14-10.00.00", generateExpectedResponse1()),
        Arguments.of("/api/v1/prices?productId=35455&brandId=1&date=2020-06-14-16.00.00", generateExpectedResponse2()),
        Arguments.of("/api/v1/prices?productId=35455&brandId=1&date=2020-06-14-21.00.00", generateExpectedResponse3()),
        Arguments.of("/api/v1/prices?productId=35455&brandId=1&date=2020-06-15-10.00.00", generateExpectedResponse4()),
        Arguments.of("/api/v1/prices?productId=35455&brandId=1&date=2020-06-16-21.00.00", generateExpectedResponse5())
    );
  }

  public static GetPriceResponseDto generateExpectedResponse1() {
    return GetPriceResponseDto.builder()
            .productId(35455)
            .brandId(1)
            .priceList(1)
            .startDate("2020-06-14-00.00.00")
            .endDate("2020-12-31-23.59.59")
            .price(35.5)
            .build();
  }

  public static GetPriceResponseDto generateExpectedResponse2() {
    return GetPriceResponseDto.builder()
            .productId(35455)
            .brandId(1)
            .priceList(2)
            .startDate("2020-06-14-15.00.00")
            .endDate("2020-06-14-18.30.00")
            .price(25.45)
            .build();
  }

  public static GetPriceResponseDto generateExpectedResponse3() {
    return GetPriceResponseDto.builder()
            .productId(35455)
            .brandId(1)
            .priceList(1)
            .startDate("2020-06-14-00.00.00")
            .endDate("2020-12-31-23.59.59")
            .price(35.5)
            .build();
  }

  public static GetPriceResponseDto generateExpectedResponse4() {
    return GetPriceResponseDto.builder()
            .productId(35455)
            .brandId(1)
            .priceList(3)
            .startDate("2020-06-15-00.00.00")
            .endDate("2020-06-15-11.00.00")
            .price(30.5)
            .build();
  }

  public static GetPriceResponseDto generateExpectedResponse5() {
    return GetPriceResponseDto.builder()
            .productId(35455)
            .brandId(1)
            .priceList(4)
            .startDate("2020-06-15-16.00.00")
            .endDate("2020-12-31-23.59.59")
            .price(38.95)
            .build();
  }
}

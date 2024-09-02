package com.inditex.inditex_test.infraestructure.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.inditex.inditex_test.infraestructure.repository.entity.PriceEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends JpaRepository<PriceEntity, UUID> {

  @Query(value = "SELECT * " +
      "FROM PRICES " +
      "WHERE PRODUCT_ID = :productId AND BRAND_ID = :brandId AND :date BETWEEN START_DATE AND END_DATE " +
      "ORDER BY (END_DATE - START_DATE) ASC " +
      "LIMIT 1", nativeQuery = true)
  PriceEntity findByProductIdAndBrandIdAndDate(final long productId,
      final long brandId, final Timestamp date);

}

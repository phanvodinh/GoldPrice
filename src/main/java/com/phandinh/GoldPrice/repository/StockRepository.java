package com.phandinh.GoldPrice.repository;

import com.phandinh.GoldPrice.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository  extends JpaRepository<Stock,Long> {

}

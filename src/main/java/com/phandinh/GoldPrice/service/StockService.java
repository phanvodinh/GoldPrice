package com.phandinh.GoldPrice.service;

import com.phandinh.GoldPrice.data.StockData;
import com.phandinh.GoldPrice.model.Stock;
import com.phandinh.GoldPrice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StockService implements IStockeService {
    @Autowired
    private StockData stockData;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public void saveStockData() {
        stockRepository.saveAll(stockData.getDataFromWeb());
    }
    public List<Stock>allData(){
        return stockRepository.findAll();

    }
}

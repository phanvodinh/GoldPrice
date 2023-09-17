package com.phandinh.GoldPrice.service;



import com.phandinh.GoldPrice.model.Stock;

import java.util.List;

public interface IStockeService {

    public void saveStockData();
    public List<Stock>allData();
}

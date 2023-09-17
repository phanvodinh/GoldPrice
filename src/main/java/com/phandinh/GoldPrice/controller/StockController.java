package com.phandinh.GoldPrice.controller;

import com.phandinh.GoldPrice.model.Stock;
import com.phandinh.GoldPrice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StockController {
    @Autowired
    private StockService service;

    @PostMapping("save")
    public void saveData() {
        service.saveStockData();
    }

    @GetMapping("all")
    public List<Stock> getAll() {
        return service.allData();
    }
}

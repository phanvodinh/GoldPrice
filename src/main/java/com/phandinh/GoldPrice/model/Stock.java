package com.phandinh.GoldPrice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Stock {
    private String name;
    private double price;
    private double priceChanged;
    private int vol1Day;
    private int vol30Days;
    private long listedVol;
    private long marketCap;
    private  double stateOwn;


}

package com.phandinh.GoldPrice.data;

import com.phandinh.GoldPrice.model.Stock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockData {
    private String name, price, priceChange, volume1Day, volume30Days, listedVolume, marketCapitalization, stateOwner;
    private List<Stock> stockData;

    public List<Stock> getDataFromWeb() {

        try {
            stockData = new ArrayList<Stock>();
            // URL của trang web bạn muốn lấy dữ liệu
            String url = "https://www.cophieu68.vn/market/markets.php"; // Thay đổi thành URL thực tế

            // Kết nối và lấy trang web
            Document document = Jsoup.connect(url).get();

            // Tìm tất cả các phần tử tr có class "stock_online border_bottom tr_body"
            Elements rows = document.select("tr.stock_online.border_bottom.tr_body");

            //lấy thời gian hiện tại lấy dữ liệu
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime currentTime = LocalDateTime.now();
            String timeFormat = formatter.format(currentTime);

            // Lặp qua các hàng và lấy thông tin
            for (Element row : rows) {
                // Lấy dữ liệu từ các thẻ td bên trong hàng
                Elements tdElements = row.select("td");

                // In ra thông tin từ các thẻ td
                for (int i = 0; i < tdElements.size(); i++) {
                    Stock stock = new Stock();
                    name = tdElements.get(0).text();
                    price = tdElements.get(1).text();
                    priceChange = tdElements.get(2).text();
                    volume1Day = tdElements.get(3).text();
                    volume30Days = tdElements.get(4).text();
                    listedVolume = tdElements.get(5).text();
                    marketCapitalization = tdElements.get(6).text();
                    stateOwner = tdElements.get(7).text();

                    stock.setName(name);
                    stock.setPrice(price);
                    stock.setPriceChanged(priceChange);
                    stock.setVol1Day(volume1Day);
                    stock.setVol30Days(volume30Days);
                    stock.setListedVol(listedVolume);
                    stock.setMarketCap(marketCapitalization);
                    stock.setStateOwn(stateOwner);
                    stockData.add(stock);
                    break;

                }

            }

            return stockData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockData;
    }

    public static void main(String[] args) {
        StockData data = new StockData();
        for (Stock stock : data.getDataFromWeb()) {
            System.out.println(stock.toString());
        }

    }


}

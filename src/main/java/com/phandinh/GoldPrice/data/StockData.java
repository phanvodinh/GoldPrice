package com.phandinh.GoldPrice.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockData {
    private static String name, price, priceChange, volume1Day, volume30Days, listedVolume, marketCapitalization, stateOwner;

    public static void getDataFromWeb() {
        try {
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
                    name = tdElements.get(0).text();
                    price = tdElements.get(1).text();
                    priceChange = tdElements.get(2).text();
                    volume1Day = tdElements.get(3).text();
                    volume30Days = tdElements.get(4).text();
                    listedVolume = tdElements.get(5).text();
                    marketCapitalization = tdElements.get(6).text();
                    stateOwner = tdElements.get(7).text();

                    System.out.println("Mã CP: " + name);
                    System.out.println("Giá: " + price);
                    System.out.println("Giá thay đổi: " + priceChange);
                    System.out.println("KLGD 1 ngày: " + volume1Day);
                    System.out.println("KLGD 30 ngày: " + volume30Days);
                    System.out.println("KL niêm yết: " + listedVolume);
                    System.out.println("Vốn hóa: " + marketCapitalization);
                    System.out.println("NN sở hữu: " + stateOwner);
                    System.out.println("Ngày lấy: " + timeFormat);
                    System.out.println("------------------------------");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        getDataFromWeb();
    }


}

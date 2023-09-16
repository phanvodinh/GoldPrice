package com.phandinh.GoldPrice.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScrapingData {

    public static void main(String[] args) {
        final String url = "https://giavangonline.com/";

        try {
            final Document document = Jsoup.connect(url).get();
            // Lấy bảng theo class
            Elements table = document.select("table.home.table.table-condensed.table-bordered");

            // Lấy tất cả các hàng trong bảng
            Elements rows = table.select("tr");

            // Bỏ qua hàng đầu tiên vì nó chứa tiêu đề cột
//            for (int i = 1; i < rows.size(); i++) {
//                Element row = rows.get(i);
//                Elements columns = row.select("td");
//
//                if (columns.size() >= 6) { // Kiểm tra có đủ số cột bạn quan tâm không
//                    String symbol = columns.get(0).text();
//                    String bid = columns.get(1).text();
//                    String ask = columns.get(2).text();
//                    String changePercent = columns.get(3).text();
//                    String high = columns.get(4).text();
//                    String low = columns.get(5).text();
//
//                    // In ra dữ liệu từng cột
//                    System.out.println("Symbol: " + symbol);
//                    System.out.println("Bid: " + bid);
//                    System.out.println("Ask: " + ask);
//                    System.out.println("Change%: " + changePercent);
//                    System.out.println("High: " + high);
//                    System.out.println("Low: " + low);
//                    System.out.println("-----------------------");
//                }

            for (Element row : rows) {
                // Lấy dữ liệu trong các ô (td) của dòng
                Elements cells = row.select("td");

                // Kiểm tra nếu có đủ ô trong dòng (có 6 ô)
                if (cells.size() == 6) {
                    String symbol = cells.get(0).text();
                    String bid = cells.get(1).text();
                    String ask = cells.get(2).text();
                    String changePercent = cells.get(3).text();
                    String high = cells.get(4).text();
                    String low = cells.get(5).text();

                    // In ra dữ liệu hoặc làm gì đó với dữ liệu ở đây
                    System.out.println("Symbol: " + symbol);
                    System.out.println("Bid: " + bid);
                    System.out.println("Ask: " + ask);
                    System.out.println("Change%: " + changePercent);
                    System.out.println("High: " + high);
                    System.out.println("Low: " + low);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

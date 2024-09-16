package com.scrapper;

import java.io.IOException;

import javax.imageio.IIOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BookScrapper {
    public static void main(String[] args) throws IOException {
        String url = "https://books.toscrape.com/";

        try {
            Document document = Jsoup.connect(url).get();
            Elements books = document.select(".product_pod");

            System.out.println("====================================");
            System.out.println("Books - Web Scrapper");
            System.out.println("====================================");
            for (Element bk : books) {
                String title = bk.select("h3 > a").text();
                String price = bk.select(".price_color").text();

                System.out.println(title + " - " + price);
            }
            System.out.println("====================================");

        } catch (IIOException e) {
            e.printStackTrace();
        }
    }
}

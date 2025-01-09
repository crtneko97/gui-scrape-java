package com.crawler.bps.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class LinkCrawlService {

    private String url;

    public LinkCrawlService(String url) {
        this.url = url;
    }

    public String crawl() {
        StringBuilder result = new StringBuilder();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                result.append("Link: ").append(link.attr("href"))
                        .append(" Text: ").append(link.text()).append("\n");
            }
        } catch (IOException e) {
            result.append("Error while fetching links: ").append(e.getMessage());
        }
        return result.toString();
    }
}

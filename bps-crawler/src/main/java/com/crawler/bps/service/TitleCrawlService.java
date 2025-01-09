package com.crawler.bps.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class TitleCrawlService {

    private String url;

    public TitleCrawlService(String url) {
        this.url = url;
    }

    public String crawl() {
        try {
            Document doc = Jsoup.connect(url).get();
            return "Title: " + doc.title() + "\n";
        } catch (IOException e) {
            return "Error while fetching the title: " + e.getMessage();
        }
    }
}

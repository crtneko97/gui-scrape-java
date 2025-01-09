package com.crawler.bps.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class MetaInfoCrawlService {

    private String url;

    public MetaInfoCrawlService(String url) {
        this.url = url;
    }

    public String crawl() {
        StringBuilder result = new StringBuilder();
        try {
            Document doc = Jsoup.connect(url).get();
            Element keywordsElement = doc.selectFirst("meta[name=keywords]");
            if (keywordsElement != null) {
                result.append("Meta keywords: ").append(keywordsElement.attr("content")).append("\n");
            } else {
                result.append("No Meta keywords found...\n");
            }

            Element descriptionElement = doc.selectFirst("meta[name=description]");
            if (descriptionElement != null) {
                result.append("Meta description: ").append(descriptionElement.attr("content")).append("\n");
            }
        } catch (IOException e) {
            result.append("Error while fetching meta information: ").append(e.getMessage());
        }
        return result.toString();
    }
}

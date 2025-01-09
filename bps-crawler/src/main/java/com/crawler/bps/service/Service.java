package com.crawler.bps.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
public class Service {

    private String url;

    public Service(String url) {
        this.url = url;
    }

    public String crawlTitle() {
        TitleCrawlService titleCrawlService = new TitleCrawlService(url);
        return titleCrawlService.crawl();
    }

    public List<String> crawlLinks() {
        LinkCrawlService linkCrawlService = new LinkCrawlService(url);
        return Collections.singletonList(linkCrawlService.crawl());
    }

    public List<String> crawlMetaInfo() {
        MetaInfoCrawlService metaInfoCrawlService = new MetaInfoCrawlService(url);
        return Collections.singletonList(metaInfoCrawlService.crawl());
    }

    public List<Object[]> crawlTables() {  // Ensure this matches the method used in CrawlerGui/Controller
        TableScrapeService tableScrapeService = new TableScrapeService(url);
        return tableScrapeService.crawl();
    }

    public void convertTablesToJson(List<Object[]> tablesData, String filePath) throws IOException {
        JsonExportService jsonExportService = new JsonExportService();
        jsonExportService.convertToJson(tablesData, filePath);
    }
}

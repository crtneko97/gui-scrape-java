package com.crawler.bps.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableScrapeService {

    private String url;

    public TableScrapeService(String url) {
        this.url = url;
    }

    public List<Object[]> crawl() {
        List<Object[]> tablesData = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements tables = doc.select("table");

            if (tables.isEmpty()) {
                tablesData.add(new Object[]{"No tables found", new String[0][0]});
                return tablesData;
            }

            for (Element table : tables) {
                List<String> columnNames = new ArrayList<>();
                List<String[]> rowData = new ArrayList<>();

                // Extract headers (th elements)
                Elements headerRows = table.select("tr");
                for (Element row : headerRows) {
                    Elements thCells = row.select("th");
                    if (!thCells.isEmpty()) {
                        for (Element th : thCells) {
                            columnNames.add(th.text().trim());
                        }
                    }
                }

                // Handle case where no headers were found
                if (columnNames.isEmpty()) {
                    columnNames.add("Column 1");
                    columnNames.add("Column 2");
                    columnNames.add("Column 3");
                }

                // Extract table rows (td elements)
                Elements rows = table.select("tr");
                for (Element row : rows) {
                    Elements tdCells = row.select("td");
                    if (tdCells.size() > 0) {
                        String[] rowValues = new String[columnNames.size()];
                        for (int i = 0; i < tdCells.size(); i++) {
                            if (i < columnNames.size()) {
                                rowValues[i] = tdCells.get(i).text().trim();
                            } else {
                                rowValues[i] = "";
                            }
                        }
                        rowData.add(rowValues);
                    }
                }

                // Add table data
                String[] columnArray = columnNames.toArray(new String[0]);
                String[][] rowArray = rowData.toArray(new String[0][]);

                tablesData.add(new Object[]{columnArray, rowArray});
            }
        } catch (IOException e) {
            tablesData.add(new Object[]{"Error fetching tables: " + e.getMessage(), new String[0][0]});
        }
        return tablesData;
    }
}

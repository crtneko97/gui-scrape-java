package com.crawler.bps.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonExportService {

    public void convertToJson(List<Object[]> tablesData, String filePath) throws IOException {
        JSONArray tablesArray = new JSONArray();

        for (Object[] tableData : tablesData) {
            String[] columnNames = (String[]) tableData[0];
            String[][] rows = (String[][]) tableData[1];

            JSONObject tableJson = new JSONObject();
            tableJson.put("columns", new JSONArray(columnNames));

            JSONArray rowsArray = new JSONArray();
            for (String[] row : rows) {
                JSONObject rowJson = new JSONObject();
                for (int i = 0; i < columnNames.length; i++) {
                    rowJson.put(columnNames[i], row[i]);
                }
                rowsArray.put(rowJson);
            }

            tableJson.put("rows", rowsArray);
            tablesArray.put(tableJson);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(tablesArray.toString(4));
            System.out.println("Successfully saved JSON to " + filePath);
        }
    }
}

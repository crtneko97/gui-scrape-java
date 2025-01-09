package com.crawler.bps.controller;

import com.crawler.bps.GUI.CrawlerGui;
import com.crawler.bps.service.Service;
import com.crawler.bps.utils.CrawlerUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CrawlerController {

    private CrawlerGui gui;

    public CrawlerController(CrawlerGui gui) {
        this.gui = gui;
        initListeners();
    }

    private void initListeners() {
        gui.getInputPanel().getCrawlButton().addActionListener(this::handleCrawlButtonAction);
        gui.getResultPanel().getGoBackButton().addActionListener(e -> gui.showInputPanel());
        gui.getDataTablePanel().getGoBackButton().addActionListener(e -> gui.showInputPanel());
        gui.getDataTablePanel().getConvertToJsonButton().addActionListener(this::handleConvertToJsonAction);
    }

    private void handleCrawlButtonAction(ActionEvent e) {
        String url = gui.getInputPanel().getUrl();
        String selectedOption = gui.getInputPanel().getSelectedCrawlOption();

        if (url.isEmpty() || selectedOption.isEmpty()) {
            showErrorMessage("Please enter a valid URL and select an option.");
            return;
        }

        if (!CrawlerUtils.isValidUrl(url)) {
            showErrorMessage("Please enter a valid URL.");
            return;
        }

        startCrawl(url, selectedOption);
    }

    private void handleConvertToJsonAction(ActionEvent e) {
        List<Object[]> allTables = gui.getDataTablePanel().getAllTablesData();
        if (allTables.isEmpty()) {
            showErrorMessage("No tables available to convert to JSON.");
            return;
        }

        String folderPath = gui.getDataTablePanel().getFolderPath();
        if (folderPath.isEmpty() || !ensureFolderExists(folderPath)) {
            return;
        }

        String fileName = gui.getDataTablePanel().getFileNameInput();
        if (!fileName.endsWith(".json")) {
            fileName += ".json";
        }

        if (!CrawlerUtils.isValidFileName(fileName)) {
            showErrorMessage("Incorrect filename");
            return;
        }

        try {
            File jsonFile = new File(folderPath, fileName);
            Service service = new Service("dummy-url");
            service.convertTablesToJson(allTables, jsonFile.getAbsolutePath());
            gui.showResultPanel("Tables successfully saved to " + jsonFile.getAbsolutePath());
        } catch (IOException ex) {
            showErrorMessage("Error saving tables to JSON: " + ex.getMessage());
        }
    }

    private boolean ensureFolderExists(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists() && !folder.mkdirs()) {
            showErrorMessage("Failed to create folder. Please select a valid folder.");
            return false;
        }
        return true;
    }

    private void startCrawl(String url, String selectedOption) {
        try {
            Service service = new Service(url);
            switch (selectedOption) {
                case "tableInfo":
                    crawlTables(service);
                    break;
                case "title":
                    gui.showTitle(service.crawlTitle());
                    break;
                case "links":
                    gui.showLinks(service.crawlLinks());
                    break;
                case "metaInfo":
                    gui.showMetaInfo(service.crawlMetaInfo());
                    break;
                default:
                    showErrorMessage("Invalid crawl option selected.");
                    break;
            }
        } catch (Exception ex) {
            showErrorMessage("Error occurred during the crawl: " + ex.getMessage());
        }
    }

    private void crawlTables(Service service) {
        List<Object[]> tables = service.crawlTables();
        if (tables.isEmpty()) {
            showErrorMessage("No tables found on the webpage.");
        } else {
            gui.showTableResult(tables);
        }
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(gui.getFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

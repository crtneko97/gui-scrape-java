package com.crawler.bps;

import com.crawler.bps.GUI.CrawlerGui;
import com.crawler.bps.controller.CrawlerController;

public class Main {
    public static void main(String[] args) {
        // Initialize the GUI
        CrawlerGui gui = new CrawlerGui();

        // Initialize the controller
        new CrawlerController(gui);

        // Show the input panel initially
        gui.showInputPanel();
    }
}

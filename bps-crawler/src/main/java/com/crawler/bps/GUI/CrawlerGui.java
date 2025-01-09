package com.crawler.bps.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;
import com.crawler.bps.GUI.inputs.InputPanel;
import com.crawler.bps.GUI.results.ResultPanel;
import com.crawler.bps.GUI.results.DataTablePanel;

public class CrawlerGui {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private InputPanel inputPanel;
    private ResultPanel resultPanel;
    private DataTablePanel dataTablePanel;

    public CrawlerGui() {
        // Set default font for UI components
        Font defaultFont = new Font("Arial", Font.PLAIN, 14);
        UIManager.put("Button.font", defaultFont);
        UIManager.put("Label.font", defaultFont);
        UIManager.put("TextField.font", defaultFont);
        UIManager.put("TextArea.font", defaultFont);
        UIManager.put("Table.font", defaultFont);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize the main frame
        frame = new JFrame("Web Crawler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(true);
        frame.getContentPane().setBackground(Color.WHITE);

        // Initialize CardLayout and Panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(Color.WHITE);

        inputPanel = new InputPanel();
        resultPanel = new ResultPanel();
        dataTablePanel = new DataTablePanel();

        // Add panels to card panel (no need for getPanel() on ResultPanel)
        cardPanel.add(inputPanel.getPanel(), "Input");
        cardPanel.add(resultPanel, "Result");  // Use resultPanel directly
        cardPanel.add(dataTablePanel, "DataTable");

        frame.setContentPane(cardPanel);
        frame.setVisible(true);
    }

    // Methods to show specific panels
    public void showInputPanel() {
        cardLayout.show(cardPanel, "Input");
    }

    public void showResultPanel(String result) {
        resultPanel.updateResults(result);
        cardLayout.show(cardPanel, "Result");
    }

    public void showLinks(List<String> links) {
        dataTablePanel.displayLinks(links);
        cardLayout.show(cardPanel, "DataTable");
    }

    public void showMetaInfo(List<String> metaInfo) {
        dataTablePanel.displayMetaInfo(metaInfo);
        cardLayout.show(cardPanel, "DataTable");
    }

    public void showTitle(String title) {
        dataTablePanel.displayTitle(Collections.singletonList(title));
        cardLayout.show(cardPanel, "DataTable");
    }

    public void showTableResult(List<Object[]> allTables) {
        dataTablePanel.displayMultipleTables(allTables);
        cardLayout.show(cardPanel, "DataTable");
    }

    public JFrame getFrame() {
        return frame;
    }

    public InputPanel getInputPanel() {
        return inputPanel;
    }

    public ResultPanel getResultPanel() {
        return resultPanel;
    }

    public DataTablePanel getDataTablePanel() {
        return dataTablePanel;
    }
}

package com.crawler.bps.GUI.results;

import com.crawler.bps.GUI.components.BottomPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DataTablePanel extends JPanel {

    private JScrollPane scrollPane;
    private JTextArea textArea;
    private List<Object[]> allTablesData;
    private BottomPanel bottomPanel;

    public DataTablePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        textArea.setEditable(false);
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(1200, 600));
        add(scrollPane, BorderLayout.CENTER);

        bottomPanel = new BottomPanel(new Font("Arial", Font.PLAIN, 12));
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void displayMultipleTables(List<Object[]> tablesData) {
        this.allTablesData = tablesData;
        StringBuilder sb = new StringBuilder();
        for (Object[] tableData : tablesData) {
            String[] columnNames = (String[]) tableData[0];
            String[][] data = (String[][]) tableData[1];

            // Add headers and rows for table data
            for (String columnName : columnNames) {
                sb.append(String.format("%-20s", columnName));
            }
            sb.append("\n");

            for (String[] row : data) {
                for (String cell : row) {
                    sb.append(String.format("%-20s", cell));
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        textArea.setText(sb.toString());
    }

    public void displayLinks(List<String> links) {
        StringBuilder sb = new StringBuilder("Links Found:\n\n");
        for (int i = 0; i < links.size(); i++) {
            sb.append(String.format("%d. %s\n", i + 1, links.get(i)));
        }
        textArea.setText(sb.toString());
    }

    public void displayMetaInfo(List<String> metaInfo) {
        StringBuilder sb = new StringBuilder("Meta Information:\n\n");
        for (String meta : metaInfo) {
            sb.append(meta).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public void displayTitle(List<String> title) {
        textArea.setText("Page Title:\n\n" + String.join("\n", title));
    }


    public JButton getGoBackButton() {
        return bottomPanel.getGoBackButton();
    }

    public JButton getConvertToJsonButton() {
        return bottomPanel.getConvertToJsonButton();
    }

    public List<Object[]> getAllTablesData() {
        return allTablesData;
    }

    public String getFolderPath() {
        return bottomPanel.getSelectedFolderPath();
    }

    public String getFileNameInput() {
        String fileName = bottomPanel.getNameFileInput().getText().trim();
        return fileName.isEmpty() ? "tablesData" : fileName;
    }
}

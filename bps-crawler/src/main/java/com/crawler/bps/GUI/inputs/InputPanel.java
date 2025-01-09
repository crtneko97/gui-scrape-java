package com.crawler.bps.GUI.inputs;

import javax.swing.*;
import java.awt.*;
import com.crawler.bps.GUI.components.ButtonComponents;
import com.crawler.bps.GUI.components.ImageComponents;

public class InputPanel {

    private JPanel panel;
    private JTextField urlField;
    private JComboBox<String> crawlOptionsComboBox;
    private JButton crawlButton;

    public InputPanel() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        Font customFont = new Font("Arial", Font.PLAIN, 12);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add Image at the top of the panel
        JLabel imageLabel = ImageComponents.createImageLabel("src/main/resources/bpslogo.png", 200, 100);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0; // Span the image across all columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the image
        panel.add(imageLabel, gbc);

        // URL Label
        JLabel urlLabel = new JLabel("URL:");
        urlLabel.setFont(customFont);
        urlLabel.setForeground(Color.BLACK);
        gbc.gridx = 0; // Column 0
        gbc.gridy = 1; // Row 1
        gbc.gridwidth = 1; // Reset gridwidth
        gbc.anchor = GridBagConstraints.WEST; // Align label to the left
        panel.add(urlLabel, gbc);

        // URL Field
        urlField = InputElements.createTextField(30, customFont);
        gbc.gridx = 1; // Column 1 (next to the label)
        gbc.gridy = 1; // Row 1 (same row as the label)
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow horizontal stretching
        panel.add(urlField, gbc);

        // Crawl Options ComboBox
        String[] crawlOptions = {"title", "links", "metaInfo", "tableInfo"};
        crawlOptionsComboBox = InputElements.createComboBox(crawlOptions, customFont);
        gbc.gridx = 2; // Column 2
        gbc.gridy = 1; // Row 1
        gbc.gridwidth = 1; // Single column
        gbc.fill = GridBagConstraints.NONE; // Reset fill
        panel.add(crawlOptionsComboBox, gbc);

        // Crawl Button
        crawlButton = ButtonComponents.createButton("Start", customFont, Color.WHITE, Color.BLACK);
        gbc.gridx = 3; // Column 3
        gbc.gridy = 1; // Row 1
        gbc.gridwidth = 1; // Single column
        gbc.anchor = GridBagConstraints.CENTER; // Center align button
        panel.add(crawlButton, gbc);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getUrlField() {
        return urlField;
    }

    public JComboBox<String> getCrawlOptionsComboBox() {
        return crawlOptionsComboBox;
    }

    public JButton getCrawlButton() {
        return crawlButton;
    }

    public String getSelectedCrawlOption() {
        return (String) crawlOptionsComboBox.getSelectedItem();
    }

    public String getUrl() {
        return urlField.getText();
    }
}

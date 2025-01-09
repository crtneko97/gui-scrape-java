package com.crawler.bps.GUI.results;

import com.crawler.bps.GUI.components.BottomPanel;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    private JTextArea textArea;
    private BottomPanel bottomPanel;

    public ResultPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        Font customFont = new Font("Arial", Font.PLAIN, 12);

        textArea = new JTextArea();
        textArea.setFont(customFont);
        textArea.setEditable(false);
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);

        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Initialize and add the BottomPanel
        bottomPanel = new BottomPanel(customFont);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public JButton getGoBackButton() {
        return bottomPanel.getGoBackButton();
    }

    public JButton getConvertToJsonButton() {
        return bottomPanel.getConvertToJsonButton();
    }

    public void updateResults(String result) {
        textArea.setText(result);
    }
}

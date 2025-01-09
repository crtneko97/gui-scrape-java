package com.crawler.bps.GUI.components;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BottomPanel extends JPanel {

    private JButton goBackButton;
    private JButton convertToJsonButton;
    private JButton browseButton;
    private JTextField nameFileInput;
    private String selectedFolderPath = "";

    public BottomPanel(Font customFont) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(Color.WHITE);

        // Initialize buttons
        goBackButton = createButton("Go Back", customFont, Color.WHITE, Color.BLACK);
        convertToJsonButton = createButton("Convert to JSON", customFont, Color.WHITE, Color.BLACK);
        browseButton = createButton("Browse Folder", customFont, Color.WHITE, Color.BLACK);

        // Initialize input field
        nameFileInput = new JTextField(15);
        nameFileInput.setFont(customFont);
        nameFileInput.setBackground(Color.WHITE);
        nameFileInput.setForeground(Color.BLACK);

        // Add components to the panel
        add(goBackButton);
        add(browseButton);
        add(nameFileInput);
        add(convertToJsonButton);

        // Add action listener to browse button
        browseButton.addActionListener(e -> openFolderChooser());
    }

    private JButton createButton(String text, Font font, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        return button;
    }

    private void openFolderChooser() {
        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = folderChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = folderChooser.getSelectedFile();
            selectedFolderPath = selectedFolder.getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Selected Folder: " + selectedFolderPath,
                    "Folder Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public JButton getConvertToJsonButton() {
        return convertToJsonButton;
    }

    public JButton getBrowseButton() {
        return browseButton;
    }

    public JTextField getNameFileInput() {
        return nameFileInput;
    }

    public String getSelectedFolderPath() {
        return selectedFolderPath;
    }
}

package com.crawler.bps.GUI.inputs;

import javax.swing.*;
import java.awt.*;

public class InputElements {

    public static JTextField createTextField(int columns, Font font) {
        JTextField textField = new JTextField(columns);
        textField.setFont(font);
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        return textField;
    }

    public static JComboBox<String> createComboBox(String[] options, Font font) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(font);
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
        return comboBox;
    }
}

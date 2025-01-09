package com.crawler.bps.GUI.components;

import javax.swing.*;
import java.awt.*;

public class PanelComponents {

    // Method to create a basic panel with a background color
    public static JPanel createPanel(Color bgColor) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        return panel;
    }

    // Method to create a panel with GridBagLayout for more complex positioning
    public static JPanel createGridBagPanel(Color bgColor) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(bgColor);
        return panel;
    }

    // Method to create a panel with BorderLayout for larger components (e.g., text area, buttons)
    public static JPanel createBorderPanel(Color bgColor) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bgColor);
        return panel;
    }
}

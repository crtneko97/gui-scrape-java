package com.crawler.bps.GUI.components;

import javax.swing.*;
import java.awt.*;

public class ButtonComponents {

    public static JButton createButton(String text, Font font, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        return button;
    }
}
